package edu.luc.cs.comp473.project1.model.service;

import java.util.List;

import edu.luc.cs.comp473.project1.dal.FacilityDAO;
import edu.luc.cs.comp473.project1.model.facility.Facility;

/**
 * This class is the interface for client UI and the domain model.
 * @author TeamDK
 *
 */
public class FacilityService {

    private FacilityDAO facilityStorage;
    private List<Facility> facilityList;
    
    public FacilityService() {
        facilityStorage = new FacilityDAO();
    }
    
    /**
     * This method returns a list of all facilities in memory.
     * @return
     */
    public List<Facility> listFacilities() {
        //TODO figure out how to get the facilities
        return facilityList;
    }
    
    /**
     * creates a facility and adds it to storage
     * @param name
     * @param description
     */
    public void addNewFacility(String name, String description) {
        Facility facility = new Facility(name, description);
        facilityStorage.insertFacility(facility);
    }
    
    /**
     * Removes the given facility from management
     * @param facility
     */
    public void removeFacility(Facility facility) {
        facilityStorage.removeFacility(facility);
    }
    
    /**
     * TODO determine what this method is meant to return
     * @return
     */
    public Facility getFacilityInformation(Facility facility) {
        return null;
    }
    
    /**
     * TODO determine what this method is meant to do
     */
    public void addFacilityDetail(Facility facility) {
        
    }
    
    /**
     * This method returns the available capacity of the entire facility
     * @return total available capacity
     */
    public int requestAvailableCapacity(Facility facility) {
        return facility.requestAvailableCapacity();
    }
    
    /**
     * This method checks if the facility is in use during a specific interval
     * @return boolean value for yes or no
     */
    public boolean isInUseDuringInterval(Facility facility) {
        return false;
    }
    
    /**
     * This method assigns a facility for a specific interval.
     */
    public void assignFacilityToUse(Facility facility) {
        
    }
    
    /**
     * This facility empties all occupants and makes all rooms available.
     */
    public void vacateFacility(Facility facility) {
        
    }
    
    /**
     * Lists all the inspections of a facility
     * TODO may require a new object to keep track of this.
     * @param facility
     * @return
     */
    public List<?> listInspections(Facility facility) {
        return null;
    }
    
    /**
     * Calculates actual usage of a facility for a year
     * @return
     */
    public int listActualUsage(Facility facility) {
        return 0;
    }
    
    /**
     * Calculates a usage rate for the year
     * @return
     */
    public int calcUsageRate(Facility facility) {
        return 0;
    }
}
