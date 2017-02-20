package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.system.ConcreteSystemLog;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * This class creates objects that are associated with a specific building
 * 
 * @author TeamDK
 *
 */
public abstract class Room {

    private int roomNumber;
    private int capacity;
    private SystemLog s;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        s = new ConcreteSystemLog();
        s.logCreate(this);
    }

    /**
     * gets the room number
     * @return room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * gets the available capacity of the room
     * @return available capacity
     */
    public int getAvailableCapacity(){
        return capacity ;
    }

    /**
     * Returns whether or not the room can hold any more inhabitants
     * @return boolean
     */
    public boolean isAvailable() {
        return !(getAvailableCapacity() == 0);
    }

    /**
     * Clears all inhabitants out of the room.
     * @return void
     */
    public void vacate(){
        s.logVacate(this);
    }

    @Override
    public String toString() {
        return "Room Number:  " + this.getRoomNumber() + "\nCapacity:  " + this.getAvailableCapacity();
    }
}
