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
    
    public FacilityService() {
        facilityStorage = new FacilityDAO();
    }
    
    /**
     * This method returns a list of all facilities in memory.
     * @return
     */
    public List<Facility> listFacilities() {
        //TODO have this call to the storage and return a list of the facilities.
        return null;
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
        //TODO add removal method here
    }
    
    public Facility getFacilityInformation() {
        return null;
    }
    
    public void addFacilityDetail() {
        
    }
    
    public int requestAvailableCapacity() {
        return 0;
    }
    
    public boolean isInUseDuringInterval() {
        return false;
    }
    
    public void assignFacilityToUse() {
        
    }
    
    public void vacateFacility() {
        
    }
    
    public List<?> listInspections() {
        return null;
    }
    
    public int listActualUsage() {
        return 0;
    }
    
    public int calcUsageRate() {
        return 0;
    }
}
