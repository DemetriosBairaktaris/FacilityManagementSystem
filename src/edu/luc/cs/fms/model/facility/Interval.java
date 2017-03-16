package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.system.SystemLog;

import java.util.Date;

public interface Interval extends Comparable<Interval> {

  /**
   * Gets the start dat.e
   * @return starting Date
   */
  public Date getStartDate();

  /**
   * Gets the end date.
   * @return end Date
   */
  public Date getEndDate();

  /**
   * Changes the end date if necessary.
   * @param endDate Date
   */
  public void setEndDate(Date endDate);

  /**
   * Sets the start date.
   * @param startDate Date
   */
  public void setStartDate(Date startDate);

  /**
   * Used to log creation of the implementing object.
   */
  public void log();

  /**
   * Sets the sysLog object.
   * @param sysLog SystemLog
   */
  public void setSysLog(SystemLog sysLog);
}