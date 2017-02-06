package edu.luc.cs.comp473.project1.dal;

import java.util.HashMap;

import edu.luc.cs.comp473.project1.model.facility.Facility;

/**
 * This class performs the I/O for storage of Facility objects.
 * @author TeamDK
 *
 */
public class FacilityDAO {
    
    private int id;
    private HashMap<Integer, Facility> facilityHashMap;
    
    public FacilityDAO() {
        facilityHashMap = new HashMap<Integer, Facility>();
    }
    
    /**
     * This method retrieves the Facility from the map.
     * @param id Unique key for the Facility object
     * @return requested Facility object
     */
    public Facility getFacility(int id) {
        return facilityHashMap.get(id);
    }
    
    /**
     * This method inserts a Facility object for storage.
     * @param facility object to be placed into storage
     */
    public void insertFacility(Facility facility) {
        facilityHashMap.put(id, facility);
    }
    
    public void removeFacility(Facility facility) {
        facilityHashMap.remove(null);
        //TODO add method here to retrieve ID from facility.
    }
    
    //TODO add method to generate unique keys for the Facility objects based on name
}
