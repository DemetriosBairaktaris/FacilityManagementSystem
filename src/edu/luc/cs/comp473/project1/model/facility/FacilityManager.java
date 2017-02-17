
package edu.luc.cs.comp473.project1.model.facility;


/**
 * 
 * @author TeamDK
 *
 */
public interface FacilityManager {
    
    /**
     * 
     * @return String
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
     * @return void
     */
    public void removeFacility(String name);
    
    /**
     * 
     * @param roomNumber
     * @param capacity
     * @param name
     */
    public void addRoomToFacility(int roomNumber, int capacity,String name);
    
    /**
     * 
     * @param name
     * @return
     */
    public Facility getFacility(String name);
}
