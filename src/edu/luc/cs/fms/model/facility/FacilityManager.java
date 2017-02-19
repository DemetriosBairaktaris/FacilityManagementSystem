
package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.maintenance.Maintenance;

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
     * 
     */
    public void addRoomToFacility(int roomNumber, int capacity);
    
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
    public String CurrentFacility();
    
    public String listRooms();
}
