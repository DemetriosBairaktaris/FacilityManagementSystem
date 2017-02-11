package edu.luc.cs.comp473.project1.model.maintenance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Schedule {

    private Date currentDate;
    private List<Date> startDate;
    private List<Date> endDate;
    private long downTime;
    
    public Schedule() {
        currentDate = new Date();
        startDate = new ArrayList<Date>();
        endDate = new ArrayList<Date>();
        downTime = 0;
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
        
        if (startDate.size() == 0) {
            return 0;
        }
        else {
            for (int i = 0; i < endDate.size(); i++) {
                downTime += endDate.get(i).getTime() - startDate.get(i).getTime();
            }
            
            downTime = TimeUnit.MILLISECONDS.toDays(downTime);
            
            return downTime;
        }

    }
    
    private boolean checkAvailability(Date date1, Date date2) {
        
        if (startDate.size() == 0) {
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
