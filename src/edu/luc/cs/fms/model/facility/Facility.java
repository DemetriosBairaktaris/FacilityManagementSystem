package edu.luc.cs.fms.model.facility;

import java.util.Date;
import java.util.List;

import edu.luc.cs.fms.model.maintenance.Maintenance;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public interface Facility {

    public void setRooms(List<Room> rooms);
    public void setInspections(List<Inspection> inspections);
    public List<Inspection> getInspections();
    public void setMaintenance(Maintenance maintenance);
    public void setUse(ConcreteUse use);
    public Use getUse();
    
  
    /**
     * Retrieves a facility name.
     * 
     * @return name
     */
    public String getName();

    /**
     * Retrieves the facility description
     * 
     * @return description
     */
    public String getDescription();

    /**
     * Retrieves the facility address
     * @return address
     */
    public String getAddress();

    /**
     * Allows calling maintenance methods by retrieving object
     * @return Maintenance
     */
    public Maintenance getMaintenance();

    /**
     * Retrieves all the rooms associated with this facility
     * @return list of Room objects
     */
    public List<Room> getRooms();

    /**
     * @return String
     */
    public String getFacilityInformation();

    /**
     * adds a room to the facility
     * @param room
     */
    public void addFacilityDetail(Room room);

    /**
     * returns the available capacity
     * @return int
     */
    public int requestAvailableCapacity();

    /**
     * vacates a facility and makes it available
     */
    public void vacateFacility();

    /**
     * Checks if facility is in use during a specified date range
     * @param start
     * @param end
     * @return boolean
     */
    public boolean isInUseDuringInterval(Date start, Date end);

    /**
     * assigns the facility to use for specified date range
     * @param start
     * @param end
     * @return boolean
     */
    public boolean assignFacilityToUse(Date start, Date end);

    /**
     * lists all the inspection results if any
     * @return String
     */
    public String listInspections();

    /**
     * lists the actual usage of the facility
     * @return String
     */
    public String listActualUsage();

    /**
     * determines the usage rate
     * @return double
     */
    public double calcUsageRate();

    /**
     * checks if any maintenance requests are open
     * @return Inspection
     */
    public boolean inspect();
    
    /**
     * used to log the creation of the implemeting object
     */
    void log();
    
    /**
     * 
     * @param description
     */
    void setDescription(String description);
    
    /**
     * 
     * @param address
     */
    void setAddress(String address);
    
    /**
     * 
     * @param name
     */
    void setName(String name);
    
    /**
     * 
     * @param sysLog
     */
    void setSysLog(SystemLog sysLog);
}
