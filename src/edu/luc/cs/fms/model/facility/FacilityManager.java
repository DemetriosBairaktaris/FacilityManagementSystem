
package edu.luc.cs.fms.model.facility;

import java.util.Date;

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
     * @return
     */
    public String getFacilityInformation();
    
    /**
     * 
     * @return
     */
    public int requestAvailableCapacity();
    
    /**
     * 
     * @param facility
     * @return void
     */
    public void addNewFacility(String name, String Desc, String address);
    
    /**
     * 
     * @param roomNumber
     * @param capacity
     * 
     */
    public void addFacilityDetail(int roomNumber, int capacity);
    
    /**
     * 
     * @param facility
     * @return void
     */
    public void removeFacility(String name);
   
    /**
     * 
     * @param name
     */
    public void getFacility(String name);
    
    /**
     * Returns to Console the current facility that the manager is holding as String
     * @return String
     */
    public String CurrentFacility();
    
    /**
     * 
     * @return String
     */
    public String listRooms();
    
/////////////////////////////USE METHODS///////////////////////////////////////////
    /**
     * 
     * @param date1
     * @param date2
     * @return
     */
    public boolean isInUseDuringInterval(Date date1, Date date2);
    
    /**
     * 
     * @param date1
     * @param date2
     * @return
     */
    public boolean assignFacilityToUse(Date date1, Date date2);
    
    /**
     * 
     */
    public void vacateFacility();
    
     /**
      * 
      * @return
      */
    public String listInspections();
    
    /**
     * 
     * @return
     */
    
    public String listActualUsage();
    
    
    /**
     * 
     * @return
     */
     public double calcUsageRate();
     
}
