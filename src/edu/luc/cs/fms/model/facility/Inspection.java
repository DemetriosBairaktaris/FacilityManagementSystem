package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.system.SystemLog;

import java.util.Date;

public interface Inspection {

  /**
   * Retrieves the inspection date.
   * @return Date
   */
  public Date getDate();

  /**
   * Gets if the inspection passed.
   * @return true if passed
   */
  public boolean getPassed();

  /**
   * Sets if the inspection passed.
   * @param passed boolean
   */
  public void setPassed(boolean passed);

  /**
   * Used to log the creation of the implementing object.
   */
  public void log();
 
  /**
   * Sets the sysLog object.
   * @param sysLog SystemLog
   */
  public void setSysLog(SystemLog sysLog);

  /**
   * Sets the date of inspection.
   * @param dateOfInspection Date
   */
  public void setDateOfInspection(Date dateOfInspection);
}
