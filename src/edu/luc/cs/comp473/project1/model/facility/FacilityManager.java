package edu.luc.cs.comp473.project1.model.facility;

import java.util.List;

import edu.luc.cs.comp473.project1.model.maintenance.MaintenanceRequest;

public interface FacilityManager {
    
    //Facility//
    public List<Facility> listFacilities ();
    public void addNewFacility(String name, String desc);
    public boolean removeFacility(Facility facility);
  
//    
//    //FacilityMaintenance//
//    public void makeFacilityMaintRequest();
//    public void scheduleMaintenance();
//    public float calcMaintenanceCostForFacility(Facility facility) ;
//    public float calcProblemRateForFacility(Facility facility);
//    public String calcDownTimeForFacility(Facility facility);
//    public List<MaintenanceRequest> listMaintRequests(Facility facility);
//    public List<String> listMaintenance(Facility facility); //TODO figure out return type
//    public String listFacilityProblems(Facility facility);
}
