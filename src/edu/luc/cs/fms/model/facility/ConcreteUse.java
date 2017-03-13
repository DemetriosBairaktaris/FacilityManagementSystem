package edu.luc.cs.fms.model.facility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public class ConcreteUse implements Use{

    private List<ConcreteInterval> intervals;
    private List<ConcreteInterval> list;
    private Date currentDate;
    private float minutesPerYear;
    private boolean newIntervalAdded;
    private SystemLog sysLog;

    public ConcreteUse(SystemLog sysLog) {
        intervals = new ArrayList<>();
        minutesPerYear = 525600;
        newIntervalAdded = false;
        this.sysLog = sysLog;
    }
    
    public void setIntervals(List<ConcreteInterval> intervals) {
      this.intervals = intervals;
    };
    public List<ConcreteInterval> getIntervals() {
      return intervals;
    };
    public void setList(List<ConcreteInterval> list) {
      this.list = list;
    };
    public List<ConcreteInterval> getList() {
      return list;
    };
    public void setMinutesPerYear(float minutesPerYear) {
      this.minutesPerYear = minutesPerYear;
    };
    public float getMinutesPerYear() {
      return minutesPerYear;
    };
    public void setNewIntervalAdded(boolean newIntervalAdded) {
      this.newIntervalAdded = newIntervalAdded;
    };
    public boolean getNewIntervalAdded() {
      return newIntervalAdded;
    };

    @Override
    public String listActualUsage() {
        String usageDates = "Usage Dates:\n";

        if (intervals.size() == 0) {
            return "No Usage";
        }

        for (ConcreteInterval i : intervals) {
            usageDates = usageDates.concat(i.getStartDate() + " - " + i.getEndDate() + "\n");
        }
        return usageDates;
    }

    @Override
    public boolean assignFacilityToUse(Date start, Date end) {
        currentDate = new Date();
        
        if (start.getTime() < currentDate.getTime()) {
            return false;
        } else if (start.getTime() >= end.getTime()) {
            return false;
        } else {
            intervals.add(new ConcreteInterval(start, end, sysLog));
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

        for (ConcreteInterval i : list) {
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

        for (ConcreteInterval i : list) {
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
        list = new LinkedList<>();
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
