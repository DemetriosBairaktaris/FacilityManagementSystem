package edu.luc.cs.comp473.project1.model.facility;

import java.util.List;



public interface FacilityManager {
    
    //Facility//
    public List<Facility> listFacilities ();
    public void addNewFacility(Facility facility);
    public boolean removeFacility(Facility facility);

}
