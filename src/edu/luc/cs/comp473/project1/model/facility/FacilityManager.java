
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
    public String listFacilities ();
    
    /**
     * 
     * @param facility
     * @return void
     */
    public void addNewFacility(String name, String Desc, String address);
    
    /**
     * 
     * @param facility
     * @return boolean
     */
    public void removeFacility(String name);
    
    public void addRoomToFacility(int roomNumber, int capacity,String name);
}
