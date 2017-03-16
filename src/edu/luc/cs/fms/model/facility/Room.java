package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.system.SystemLog;

/**
 * This class creates objects that are associated with a specific building.
 * 
 * @author TeamDK
 *
 */
public interface Room {

  /**
   * Gets the room number.
   * @return room number
   */
  public int getRoomNumber();

  /**
   * Gets the available capacity of the room.
   * @return available capacity
   */
  public int getAvailableCapacity();

  /**
   * Returns whether or not the room can hold any more inhabitants.
   * @return boolean
   */
  public boolean isAvailable();

  /**
   * Clears all inhabitants out of the room.
   */
  public void vacate();

  /**
   * Logs the object.
   */
  public void log();
  
  /**
   * Sets the room number.
   * @param roomNumber integer
   */
  public void setRoomNumber(int roomNumber);
    
  /**
   * Sets the room capacity.
   * @param capacity integer
   */
  public void setCapacity(int capacity);
    
  /**
   * Sets the system log object.
   * @param sysLog SystemLog
   */
  public void setSysLog(SystemLog sysLog);
}
