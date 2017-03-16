package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.system.SystemLog;

/**
 * Concrete implementation of Room.
 * @author TeamDK
 */
public class BasicRoom implements Room {

  private int roomNumber;
  private int capacity;
  private SystemLog sysLog;
    
  public BasicRoom() {}

  @Override
  public void log() {
    sysLog.logCreate(this);
  }

  @Override
  public void setSysLog(SystemLog sysLog) {
    this.sysLog = sysLog ; 
  }

  @Override
  public int getRoomNumber() {
    return roomNumber;
  }
    
  @Override
  public int getAvailableCapacity() {
    return capacity ;
  }
    
  @Override
  public boolean isAvailable() {
    return !(getAvailableCapacity() == 0);
  }
    
  @Override
  public void vacate() {
    sysLog.logVacate(this);
  }
    
  @Override
  public String toString() {
    return "Room Number:  " + this.getRoomNumber() + "\nCapacity:  " + this.getAvailableCapacity();
  }
    
  @Override
  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }
    
  @Override 
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}