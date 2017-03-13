package edu.luc.cs.fms.dal;

import java.util.HashMap;
import java.util.Map;

import edu.luc.cs.fms.model.facility.Facility;

/**
 * This class performs the I/O for storage of Facility objects.
 * 
 * @author TeamDK
 *
 */
public class ConcreteFacilityDAO implements FacilityDAO {

    private Map<Integer, Facility> facilityHashMap;

    public ConcreteFacilityDAO() {
        //facilityHashMap = new HashMap<Integer, Facility>();
    }
    
    public void setFacilityHashMap(Map<Integer, Facility> facilityHashMap) {
      this.facilityHashMap = facilityHashMap;
    };
    public Map<Integer, Facility> getFacilityHashMap() {
      return facilityHashMap;
    };

    /**
     * This method retrieves the Facility from the memory using the hash code
     * for its name as the ID.
     * 
     * @param name of facility
     * @return requested Facility object
     */
    @Override
    public Facility getFacility(String name) {
        return facilityHashMap.get(name.hashCode());
    }

    /**
     * This method inserts a Facility object for storage.
     * 
     * @param facility object to be placed into storage
     */
    @Override
    public void insertFacility(Facility facility) {
        facilityHashMap.put(facility.getName().hashCode(), facility);
    }

    /**
     * This method removes a facility based on the facilities ID.
     * 
     * @param name
     * @return void
     */
    @Override
    public void removeFacility(String name) {
        facilityHashMap.remove(name.hashCode());
    }

    /**
     * This method prints out key,value pairs in the "database"
     * 
     * @return String
     * 
     */
    @Override
    public String toString() {
        String result = "Facilities:\n";
        if (facilityHashMap.size() == 0) {
            result += "None";
        } else {
            for (Integer i : facilityHashMap.keySet()) {
                result += "id:  " + i + "\n" + facilityHashMap.get(i).toString() + "\n";
            }
        }
        return result;
    }
}
