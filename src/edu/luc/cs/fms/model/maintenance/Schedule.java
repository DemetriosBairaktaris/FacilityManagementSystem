package edu.luc.cs.fms.model.maintenance;

import java.util.Date;
import java.util.List;

public interface Schedule {

  /**
   * Sets current date.
   * @param currentDate Date
   */
  public void setCurrentDate(Date currentDate);
  
  /**
   * Sets the starting date list.
   * @param startDate List
   */
  public void setStartDate(List<Date> startDate);
  
  /**
   * Sets the ending date list.
   * @param endDate List
   */
  public void setEndDate(List<Date> endDate);

  /**
   * Sets the facility down time.
   * @param downTime long
   */
  public void setDownTime(long downTime);

  /**
   * Schedules the request's maintenance.
   * @param start Date
   * @param end Date
   * @return true if successful, false if failure
   */
  public boolean scheduleMaintenance(Date start, Date end);

  /**
   * Calculates the down time for the selected facility.
   * @return total down time for facility from total maintenance
   */
  public long calcDownTimeForFacility();
}
