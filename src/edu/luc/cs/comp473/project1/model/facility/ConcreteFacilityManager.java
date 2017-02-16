
package edu.luc.cs.comp473.project1.model.facility;

import java.util.LinkedList;
import java.util.List;
/**
 * 
 * @author TeamDK
 *
 */
public class ConcreteFacilityManager implements FacilityManager {
    
    private List<Facility> facilities ;
    
   
    public ConcreteFacilityManager(){
        facilities = new LinkedList<>();
    }
    
    /**
     * @return facilities
     */
    @Override
    public List<Facility> listFacilities() {
        return facilities ; 
    }
    
    /**
     * @param facility
     */
    @Override
    public void addNewFacility(Facility facility) {
        facilities.add(facility);
    }
    
    /**
     * @param facility
     * @return boolean
     */
    @Override
    public boolean removeFacility(Facility facility) {
        boolean val = facilities.remove(facility);
        return val ; 
    }
}
