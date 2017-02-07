package edu.luc.cs.comp473.project1.model.service;

import java.util.List;

import edu.luc.cs.comp473.project1.dal.MaintenanceDAO;
import edu.luc.cs.comp473.project1.model.facility.Facility;
import edu.luc.cs.comp473.project1.model.maintenance.MaintenanceRequest;

/**
 * This class is the interface between the client and the domain model for the maintenance objects
 * @author TeamDK
 *
 */
public class MaintenanceService {

    private MaintenanceDAO maintenanceStorage;
    
    public MaintenanceService() {
        maintenanceStorage = new MaintenanceDAO();
    }
    
    public void makeFacilityMaintenanceRequest(Facility facility, String problem) {
        MaintenanceRequest request = new MaintenanceRequest(problem);
        facility.addMaintenance(request);
    }
    
    public void scheduleMaintenance() {
        
    }
    
    public int calcMaintenanceCostForFacility() {
        return 0;
    }
    
    public int calcProblemRateForFacility() {
        return 0;
    }
    
    public int calcDownTimeForFacility() {
        return 0;
    }
    
    public List<MaintenanceRequest> listMaintenanceRequests() {
        return null;
    }
    
    public List<MaintenanceRequest> listMaintenance() {
        return null;
    }
    
    public List<MaintenanceRequest> listFacilityProblems() {
        return null;
    }
}
