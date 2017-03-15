package edu.luc.cs.fms.model.facility;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public class ConcreteUse implements Use{

    private List<Interval> intervals;
    private List<Interval> list;
    private Date currentDate;
    private float minutesPerYear;
    private boolean newIntervalAdded;
    private SystemLog sysLog;
    private ApplicationContext context ; 

    public ConcreteUse() {
        minutesPerYear = 525600;
        newIntervalAdded = false;
        context = new ClassPathXmlApplicationContext("/META-INF/facility-context.xml");
    }
    
    @Override
    public void log(){
        sysLog.logCreate(this);;
    }
    
    @Override
    public void setSysLog(SystemLog sysLog){
        this.sysLog = sysLog ; 
    }
    
    @Override
    public void setIntervals(List<Interval> intervals) {
      this.intervals = intervals;
    };
    
    @Override
    public List<Interval> getIntervals() {
      return intervals;
    };
    
    @Override
    public void setList(List<Interval> list) {
      this.list = list;
    };
    
    @Override
    public void setMinutesPerYear(float minutesPerYear) {
      this.minutesPerYear = minutesPerYear;
    };
    
    @Override
    public float getMinutesPerYear() {
      return minutesPerYear;
    };

    @Override
    public String listActualUsage() {
        String usageDates = "Usage Dates:\n";

        if (intervals.size() == 0) {
            return "No Usage";
        }

        for (Interval i : intervals) {
            usageDates = usageDates.concat(i.getStartDate() + " - " + i.getEndDate() + "\n");
        }
        return usageDates;
    }

    @Override
    public boolean assignFacilityToUse(Date start, Date end) {
        currentDate =(Date) context.getBean("date");
        
        if (start.getTime() < currentDate.getTime()) {
            return false;
        } else if (start.getTime() >= end.getTime()) {
            return false;
        } else {
            Interval interval = (Interval)context.getBean("interval");
            interval.setStartDate(start);
            interval.setEndDate(end);
            interval.log();
            intervals.add(interval);
            newIntervalAdded = true;
            return true;
        }
    }

    @Override
    public boolean isInUseDuringInterval(Date start, Date end) {
        if (intervals.size() == 0) {
            return false;
        }
        
        if (newIntervalAdded) {
            sortAndCombine();
            newIntervalAdded = false;
        }

        for (Interval i : list) {
            if (start.getTime() >= i.getStartDate().getTime() && end.getTime() <= i.getEndDate().getTime()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calcUsageRate() {
        double totalMinutes = 0;
        
        if (newIntervalAdded) {
            sortAndCombine();
            newIntervalAdded = false;
        }

        for (Interval i : list) {
            double val = i.getEndDate().getTime() - i.getStartDate().getTime();
            val = val / 1000;
            val = val / 60;
            totalMinutes += val;
        }
        return totalMinutes / minutesPerYear;
    }

    /**
     * A helper method which sorts all intervals and combines overlapping
     * intervals Only called if there has been new additions to the intervals
     */
    private void sortAndCombine() {
        Collections.sort(intervals);
        list.clear();
        list.add(intervals.get(0));
        
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).getStartDate().getTime() == list.get(0).getStartDate().getTime()) {
                if (intervals.get(i).getEndDate().getTime() > list.get(0).getEndDate().getTime()) {
                    list.get(0).setEndDate(intervals.get(i).getEndDate());
                }
            } else if (intervals.get(i).getEndDate().getTime() > list.get(0).getEndDate().getTime()) {
                list.add(0, intervals.get(i));
            }
        }
    }


   
}
