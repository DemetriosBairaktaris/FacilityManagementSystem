package edu.luc.cs.fms.dal;

import edu.luc.cs.fms.model.facility.Facility;

public interface FacilityDAO {
    
    /**
     * This method retrieves the Facility from the memory using the hash code
     * for its name as the ID.
     * 
     * @param name of facility
     * @return requested Facility object
     */
    public Facility getFacility(String name);

    /**
     * This method inserts a Facility object for storage.
     * 
     * @param facility object to be placed into storage
     */
    public void insertFacility(Facility facility);

    /**
     * This method removes a facility based on the facilities ID.
     * 
     * @param name
     * @return void
     */
    public void removeFacility(String name);
}
