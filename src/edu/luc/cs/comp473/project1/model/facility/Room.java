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

    public Room(int roomNumber, int capacity) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        inhabitants = new ArrayList<>(capacity);
    }

    public int getRoomNumber() {
        return roomNumber;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public int getAvailableCapacity(){
        return capacity - inhabitants.size();
    }
    
    public void addInhabitant(String name) throws Exception{
        if(!isAvailable()){
           throw new Exception("NO VACANCY EXCEPTION IN ROOM "+ roomNumber);
        }
        else{
            inhabitants.add(name);
        }
    }
    /**
     * returns availability.Used to determine total availability of building and facility.
     * @return boolean
     */
    public boolean isAvailable() {
       return !(getAvailableCapacity()==0);
    }
    
    public void vacate(){
        inhabitants.clear();
    }
}
