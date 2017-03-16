package edu.luc.cs.fms.dal;

import edu.luc.cs.fms.model.facility.Facility;

import java.util.Map;

public interface FacilityData {
    
  /**
   * Sets the hash map for the DAO.
   * @param facilityHashMap map storage structure
   */
  public void setFacilityHashMap(Map<Integer, Facility> facilityHashMap);
  
  /**
   * This method retrieves the Facility from the memory using the hash code
   * for its name as the ID.
   * @param name of facility
   * @return requested Facility object
   */
  public Facility getFacility(String name);

  /**
   * This method inserts a Facility object for storage.
   * @param facility object to be placed into storage
   */
  public void insertFacility(Facility facility);

  /**
   * This method removes a facility based on the facilities ID.
   * @param name name of facility
   */
  public void removeFacility(String name);
}