package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.model.maintenance.Maintenance;
import edu.luc.cs.fms.model.system.SystemLog;

import java.util.Date;
import java.util.List;

/**
 * This interface defines a facility.
 * @author TeamDK
 *
 */
public interface Facility {

  /**
   * Sets the rooms list.
   * @param rooms List
   */
  public void setRooms(List<Room> rooms);
  
  /**
   * Sets the inspection list.
   * @param inspections List
   */
  public void setInspections(List<Inspection> inspections);
  
  /**
   * Sets the maintenance object.
   * @param maintenance Maintenance
   */
  public void setMaintenance(Maintenance maintenance);
  
  /**
   * Sets the use object.
   * @param use Use
   */
  public void setUse(Use use);

  /**
   * Retrieves a facility name.
   * 
   * @return name
   */
  public String getName();

  /**
   * Retrieves the facility description.
   * 
   * @return description
   */
  public String getDescription();

  /**
   * Retrieves the facility address.
   * @return address
   */
  public String getAddress();

  /**
   * Allows calling maintenance methods by retrieving object.
   * @return Maintenance
   */
  public Maintenance getMaintenance();

  /**
   * Retrieves all the rooms associated with this facility.
   * @return list of Room objects
   */
  public List<Room> getRooms();

  /**
   * Gets the facility information.
   * @return String
   */
  public String getFacilityInformation();

  /**
   * Adds a room to the facility.
   * @param room Room
   */
  public void addFacilityDetail(Room room);

  /**
   * Returns the available capacity.
   * @return integer
   */
  public int requestAvailableCapacity();

  /**
   * Vacates a facility and makes it available.
   */
  public void vacateFacility();

  /**
   * Checks if facility is in use during a specified date range.
   * @param start Date
   * @param end Date
   * @return boolean
   */
  public boolean isInUseDuringInterval(Date start, Date end);

  /**
   * Assigns the facility to use for specified date range.
   * @param start Date
   * @param end Date
   * @return boolean
   */
  public boolean assignFacilityToUse(Date start, Date end);

  /**
   * Lists all the inspection results if any.
   * @return String
   */
  public String listInspections();

  /**
   * Lists the actual usage of the facility.
   * @return String
   */
  public String listActualUsage();

  /**
   * Determines the usage rate.
   * @return double
   */
  public double calcUsageRate();

  /**
   * Checks if any maintenance requests are open.
   * @return Inspection
   */
  public boolean inspect();
  
  /**
   * Used to log the creation of the implementing object.
   */
  public void log();
  
  /**
   * Sets the description.
   * @param description String
   */
  public void setDescription(String description);
  
  /**
   * Sets the address.
   * @param address String
   */
  public void setAddress(String address);
  
  /**
   * Sets the name.
   * @param name String
   */
  void setName(String name);
  
  /**
   * Sets the SystemLog object.
   * @param sysLog SystemLog
   */
  void setSysLog(SystemLog sysLog);
}
