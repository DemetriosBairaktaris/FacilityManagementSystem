package edu.luc.cs.comp473.project1.model.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Schedule {

    private Date currentDate;
    private List<Date> startDate;
    private List<Date> endDate;
    
    public Schedule() {
        currentDate = new Date();
        startDate = new ArrayList<Date>();
        endDate = new ArrayList<Date>();
    }
    
    public boolean scheduleMaintenance(Date date1, Date date2) {
        
        if (currentDate.getTime() > date1.getTime() ) {
            return false;
        }
        else if (date1.getTime() >= date2.getTime()) {
            return false;
        }
        else if (checkAvailability(date1, date2)) {
            startDate.add(date1);
            endDate.add(date2);
            return true;
        }
        else {
            return false;
        }
    }
    
    public long calcDownTimeForFacility() {
        
        if (startDate == null) {
            return 0;
        }
        else {
            
            Date firstDate = startDate.get(0);
            Date lastDate = new Date();
            long downTime = 0;
            for (int i = 0; i < endDate.size(); i++) {
                if (endDate.get(i).after(lastDate)) {
                    lastDate.setTime(endDate.get(i).getTime());
                }
            }
            downTime = lastDate.getTime() - firstDate.getTime();
            downTime = TimeUnit.MILLISECONDS.toDays(downTime);
            return downTime;
        }

    }
    
    private boolean checkAvailability(Date date1, Date date2) {
        
        if (startDate == null) {
            return true;
        }
        
        for (int i = 0; i < startDate.size(); i++) {
            if (startDate.get(i).before(date1)) {
                if (endDate.get(i).after(date2)) {
                    return false;
                }
                else if (endDate.get(i).before(date2)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
