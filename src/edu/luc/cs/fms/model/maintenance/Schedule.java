package edu.luc.cs.fms.model.maintenance;

import java.util.Date;
import java.util.List;

public interface Schedule {
  
    public void setCurrentDate(Date currentDate);
    public Date getCurrentDate();
    public void setStartDate(List<Date> startDate);
    public List<Date> getStartDate();
    public void setEndDate(List<Date> endDate);
    public List<Date> getEndDate();
    public void setDownTime(long downTime);
    public long getDownTime();
  
    /**
     * schedules the request's maintenance
     * @param start
     * @param end
     * @return true if successful, false if failure
     */
    public boolean scheduleMaintenance(Date start, Date end);

    /**
     * @return total down time for facility from total maintenance
     */
    public long calcDownTimeForFacility();
}
