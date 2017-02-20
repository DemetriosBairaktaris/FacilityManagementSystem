package edu.luc.cs.fms.model.facility;

import java.util.Date;

import edu.luc.cs.fms.model.maintenance.Maintenance;

/**
 * 
 * @author TeamDK
 *
 */
public interface FacilityManager extends Maintenance {

    /**
     * 
     * @return list of facilities in a string
     */
    public String listFacilities();

    /**
     * 
     * @return all pertinent facility information in a string
     */
    public String getFacilityInformation();

    /**
     * 
     * @return available capacity
     */
    public int requestAvailableCapacity();

    /**
     * creates a new facility object
     * @param name
     * @param Desc
     * @param address
     */
    public void addNewFacility(String name, String Desc, String address);

    /**
     * adds a new room or detail to the facility
     * @param roomNumber
     * @param capacity
     */
    public void addFacilityDetail(int roomNumber, int capacity);

    /**
     * removes a facility from management
     * @param name
     */
    public void removeFacility(String name);

    /**
     * returns a facility
     * @param name
     */
    public void getFacility(String name);

    /**
     * shows the current facility in a string
     * @return
     */
    public String currentFacility();

    /**
     * lists all rooms and their information
     * @return
     */
    public String listRooms();

    /**
     * checks if facility is in use during specific interval
     * @param date1
     * @param date2
     * @return true if successful
     */
    public boolean isInUseDuringInterval(Date date1, Date date2);

    /**
     * assigns facility for usage in a specified date range
     * @param date1
     * @param date2
     * @return true if successful
     */
    public boolean assignFacilityToUse(Date date1, Date date2);

    /**
     * vacates a facility
     */
    public void vacateFacility();

    /**
     * lists all inspections
     * @return list of inspections
     */
    public String listInspections();

    /**
     * lists actual usage 
     * @return actual usage
     */
    public String listActualUsage();

    /**
     * 
     * @return calculated usage rate
     */
     public double calcUsageRate();

     /**
      * inspects a facility
      * @return true if passed
      */
     public boolean inspect();
}
