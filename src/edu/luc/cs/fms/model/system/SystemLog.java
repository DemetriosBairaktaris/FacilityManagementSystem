package edu.luc.cs.fms.model.system;

import java.util.Date;

public interface SystemLog {

  /**
   * Logs creation of an object.
   * @param object focused object
   */
  public void logCreate(Object object);

  /**
   * Logs vacating an object.
   * @param object focused object
   */
  public void logVacate(Object object);

  /**
   * Logs inspection of an object.
   * @param object focused object
   */
  public void logInspect(Object object);

  /**
   * Logs adding an object to another.
   * @param object1 object added to
   * @param object2 object to add
   */
  public void logAdd(Object object1, Object object2);

  /**
   * Logs the closing of an object.
   * @param object focused object
   */
  public void logClose(Object object);

  /**
   * Logs the scheduling of two dates for maintenance.
   * @param start starting date
   * @param end ending date
   */
  public void logSchedule(Date start, Date end);

}
