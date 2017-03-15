package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * Concrete implementation of Room
 * @author TeamDK
 */
public class BasicRoom implements Room {
    
    private int roomNumber;
    private int capacity;
    private SystemLog sysLog;
    
    public BasicRoom(int roomNumber, int capacity, SystemLog sysLog) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.sysLog = sysLog;
        sysLog.logCreate(this);
    }
    
    @Override
    public int getRoomNumber() {
        return roomNumber;
    }
    
    @Override
    public int getAvailableCapacity(){
        return capacity ;
    }
    
    @Override
    public boolean isAvailable() {
        return !(getAvailableCapacity() == 0);
    }
    
    @Override
    public void vacate(){
        sysLog.logVacate(this);
    }
    
    @Override
    public String toString() {
        return "Room Number:  " + this.getRoomNumber() + "\nCapacity:  " + this.getAvailableCapacity();
    }
}
