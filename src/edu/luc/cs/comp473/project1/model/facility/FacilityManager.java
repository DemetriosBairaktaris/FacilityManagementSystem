
package edu.luc.cs.comp473.project1.model.facility;

import java.util.List;
/**
 * 
 * @author TeamDK
 *
 */
public interface FacilityManager {
    //Facility//
    /**
     * 
     * @return List<Facility>
     */
    public List<Facility> listFacilities ();
    
    /**
     * 
     * @param facility
     * @return void
     */
    public void addNewFacility(Facility facility);
    
    /**
     * 
     * @param facility
     * @return boolean
     */
    public boolean removeFacility(Facility facility);
}
