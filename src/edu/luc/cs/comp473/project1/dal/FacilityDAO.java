package edu.luc.cs.comp473.project1.dal;

import java.util.HashMap;

import edu.luc.cs.comp473.project1.model.facility.Facility;

/**
 * This class performs the I/O for storage of Facility objects.
 * @author TeamDK
 *
 */
public class FacilityDAO {
    
    private HashMap<Integer,Facility> facilityHashMap;
    
    public FacilityDAO() {
        facilityHashMap = new HashMap<>();
    }
    
    /**
     * This method retrieves the Facility from the memory using the hash code for its name
     * as the ID.
     * @param  name name of facility
     * @return requested Facility object
     */
    public Facility getFacility(String name) {
        return facilityHashMap.get(name.hashCode());
    }
    
    /**
     * This method inserts a Facility object for storage.
     * @param facility object to be placed into storage
     */
    public void insertFacility(Facility facility) {
        facilityHashMap.put(facility.getName().hashCode(), facility);
    }
    
    /**
     * This method removes a facility based on the facilities ID.
     * @param name
     * @return 
     */
    public void removeFacility(String name) {
        facilityHashMap.remove(name.hashCode());
    }
    
    @Override
    public String toString(){
        return facilityHashMap.toString();
    }
}
