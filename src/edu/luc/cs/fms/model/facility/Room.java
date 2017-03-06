package edu.luc.cs.fms.model.facility;

/**
 * This class creates objects that are associated with a specific building
 * 
 * @author TeamDK
 *
 */
public interface Room {
    /**
     * gets the room number
     * @return room number
     */
    public int getRoomNumber();

    /**
     * gets the available capacity of the room
     * @return available capacity
     */
    public int getAvailableCapacity();

    /**
     * Returns whether or not the room can hold any more inhabitants
     * @return boolean
     */
    public boolean isAvailable();

    /**
     * Clears all inhabitants out of the room.
     * @return void
     */
    public void vacate();
}
