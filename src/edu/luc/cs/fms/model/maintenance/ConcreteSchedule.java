package edu.luc.cs.fms.model.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import edu.luc.cs.fms.model.system.SystemLog;

/**
 * This class handles all the scheduling of orders and maintenance.
 * 
 * @author TeamDK
 *
 */
public class ConcreteSchedule {

    private Date currentDate;
    private List<Date> startDate;
    private List<Date> endDate;
    private long downTime;
    private SystemLog sysLog;

    public ConcreteSchedule(SystemLog sysLog) {
        currentDate = new Date();
        startDate = new ArrayList<Date>();
        endDate = new ArrayList<Date>();
        downTime = 0;
        this.sysLog = sysLog;
    }

    /**
     * schedules the request's maintenance
     * @param start
     * @param end
     * @return true if successful, false if failure
     */
    public boolean scheduleMaintenance(Date start, Date end) {

        if (currentDate.getTime() > start.getTime()) {
            return false;
        } else if (start.getTime() >= end.getTime()) {
            return false;
        } else if (checkAvailability(start, end)) {
            startDate.add(start);
            endDate.add(end);
            sysLog.logSchedule(start, end);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return total down time for facility from total maintenance
     */
    public long calcDownTimeForFacility() {
        if (startDate.size() == 0) {
            return 0;
        } else {
            for (int i = 0; i < endDate.size(); i++) {
                downTime += endDate.get(i).getTime() - startDate.get(i).getTime();
            }
            downTime = TimeUnit.MILLISECONDS.toDays(downTime);
            return downTime;
        }
    }

    /**
     * @param start
     * @param end
     * @return true if available, false if unavailable
     */
    private boolean checkAvailability(Date start, Date end) {
        if (startDate.size() == 0) {
            return true;
        }
        for (int i = 0; i < startDate.size(); i++) {
            if (startDate.get(i).before(start)) {
                if (endDate.get(i).after(end)) {
                    return false;
                } else if (endDate.get(i).before(end)) {
                    return false;
                }
            }
        }
        return true;
    }
}
