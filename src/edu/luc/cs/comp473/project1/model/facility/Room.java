package edu.luc.cs.comp473.project1.model.facility;

/**
 * This class creates objects that are associated with a specific building
 * @author TeamDK
 *
 */
public class Room {

    private int roomNumber;
    private int capacity;
    private boolean available;

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.available = true;
    }

    /**
     * Sets if the room is available.
     * @param v true for available, false for unavailable
     */
    public void setAvailability(boolean v) {
        this.available = v;
    }

    /**
     * returns availability.Used to determine total availability of building and facility.
     * @return boolean
     */
    public boolean isAvailable() {
        return this.available;
    }
}
