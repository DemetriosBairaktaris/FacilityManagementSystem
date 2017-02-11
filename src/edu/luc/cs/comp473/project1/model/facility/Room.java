package edu.luc.cs.comp473.project1.model.facility;

import java.util.ArrayList;
import java.util.List;

/**
 * This class creates objects that are associated with a specific building
 * @author TeamDK
 *
 */
public class Room {

    private int roomNumber;
    private int capacity;
    private List<String> inhabitants ; 

    /**
     * @param roomNumber
     * @param capacity
     */
    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        inhabitants = new ArrayList<>(capacity);
    }

    /**
     * gets the room number
     * @return int
     */
    public int getRoomNumber() {
        return roomNumber;
    }
    
    /**
     * gets the capacity of the room
     * @return int
     */
    public int getCapacity() {
        return capacity;
    }
    
    /**
     * gets the available capacity of the room
     * @return int
     */
    public int getAvailableCapacity(){
        return capacity - inhabitants.size();
    }
    
    /**
     * adds an inhabitant to the room
     * @param name
     * @throws Exception
     * @return void
     */
    public void addInhabitant(String name) throws Exception{
        if(!isAvailable()){
           throw new Exception("NO VACANCY EXCEPTION IN ROOM "+ roomNumber);
        }
        else{
            inhabitants.add(name);
        }
    }
    
    /**
     * Returns whether or not the room can hold any more inhabitants
     * @return boolean
     */
    public boolean isAvailable() {
       return !(getAvailableCapacity()==0);
    }
    
    /*
     * Clears all inhabitants out of the room.
     * @return void
     */
    public void vacate(){
        inhabitants.clear();
    }
}
