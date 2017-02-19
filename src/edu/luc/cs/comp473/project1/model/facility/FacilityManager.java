
package edu.luc.cs.comp473.project1.model.facility;

import edu.luc.cs.comp473.project1.model.maintenance.Maintenance;

/**
 * 
 * @author TeamDK
 *
 */
public interface FacilityManager extends Maintenance{
    
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
    public void getFacility(String name);
    
    /**
     * Prints to Console the current facility that the manager is holding
     * @return
     */
    public String printCurrentFacility();
    
    public String listRooms();
}
