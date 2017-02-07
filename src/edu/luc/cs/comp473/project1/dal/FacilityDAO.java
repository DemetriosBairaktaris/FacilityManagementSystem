package edu.luc.cs.comp473.project1.dal;

import java.util.HashMap;

import edu.luc.cs.comp473.project1.model.facility.Facility;

/**
 * This class performs the I/O for storage of Facility objects.
 * @author TeamDK
 *
 */
public class FacilityDAO {
    
    private HashMap<Integer, Facility> facilityHashMap;
    
    public FacilityDAO() {
        facilityHashMap = new HashMap<Integer, Facility>();
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
        facilityHashMap.put(facility.getID(), facility);
    }
    
    /**
     * This method removes a facility based on the facilities ID.
     * @param facility
     */
    public void removeFacility(Facility facility) {
        facilityHashMap.remove(facility.getID());
    }
}
