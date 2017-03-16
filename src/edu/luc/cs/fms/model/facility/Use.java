package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.system.SystemLog;

import java.util.Date;
import java.util.List;

/**
 * This interface describes the use methods.
 * @author TeamDK
 *
 */
public interface Use {

  /**
   * Sets the list of intervals.
   * @param intervals List
   */
  public void setIntervals(List<Interval> intervals);
  
  /**
   * Sets the list of intervals list.
   * @param list list
   */
  public void setList(List<Interval> list);
  
  /**
   * Sets the minutes per year value.
   * @param minutesPerYear float
   */
  public void setMinutesPerYear(float minutesPerYear);

  /**
   * Returns a string of the actual usage.
   * @return list of actual usage
   */
  public String listActualUsage();

  /**
   * Assigns a facility to use between specified dates.
   * @param start Date
   * @param end Date
   * @return true if successful
   */
  public boolean assignFacilityToUse(Date start, Date end);

  /**
   * Checks if facility is in use during specific interval.
   * @param start Date
   * @param end Date
   * @return boolean
   */
  public boolean isInUseDuringInterval(Date start, Date end);

  /**
   * Determines the total usage rate.
   * @return double
   */
  public double calcUsageRate();
    
  /**
   * This sets the sysLog object.
   * @param sysLog SystemLog
   */
  public void setSysLog(SystemLog sysLog);
    
  /**
   * Used to log creation of implementing object.
   */
  public void log();
}
