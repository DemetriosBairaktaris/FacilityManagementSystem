package edu.luc.cs.comp473.project1.model.facility;

import java.util.LinkedList;
import java.util.List;

public class ConcreteFacilityManager implements FacilityManager {
    
    private List<Facility> facilities ;
    
    public ConcreteFacilityManager(){
        facilities = new LinkedList<>();
    }
    @Override
    public List<Facility> listFacilities() {
        return facilities ; 
    }

    @Override
    public void addNewFacility(Facility facility) {
        facilities.add(facility);
    }

    @Override
    public boolean removeFacility(Facility facility) {
        return facilities.remove(facility);
    }

}
