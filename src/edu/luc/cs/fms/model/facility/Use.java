package edu.luc.cs.fms.model.facility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author TeamDK
 *
 */
public class Use {

    private List<Interval> intervals;
    private List<Interval> list;
    private Date currentDate;
    private float minutesPerYear;
    private boolean newIntervalAdded;

    public Use() {
        intervals = new ArrayList<>();
        minutesPerYear = 525600;
        newIntervalAdded = false;
    }

    /**
     * 
     * @return list of actual usage
     */
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

    /**
     * assigns a facility to use between specified dates
     * @param start
     * @param end
     * @return true if successful
     */
    public boolean assignFacilityToUse(Date start, Date end) {
        currentDate = new Date();
        
        if (start.getTime() < currentDate.getTime()) {
            return false;
        } else if (start.getTime() >= end.getTime()) {
            return false;
        } else {
            intervals.add(new Interval(start, end));
            newIntervalAdded = true;
            return true;
        }
    }

    /**
     * checks if facility is in use during specific interval
     * @param start
     * @param end
     * @return boolean
     */
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

    /**
     * determines the total usage rate
     * @return double
     */
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
