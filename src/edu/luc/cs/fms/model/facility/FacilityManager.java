package edu.luc.cs.fms.model.facility;

import edu.luc.cs.fms.dal.FacilityData;
import edu.luc.cs.fms.model.maintenance.MaintenanceRequest;
import edu.luc.cs.fms.model.maintenance.Order;
import edu.luc.cs.fms.model.system.SystemLog;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * This class defines a facility manager.
 * @author TeamDK
 *
 */
public interface FacilityManager {

  /**
   * Lists the facilities.
   * @return String
   */
  public String listFacilities();
  
  /**
   * All pertinent facility information in a string.
   * @return String
   */
  public String getFacilityInformation();
  
  /**
   * Available capacity.
   * @return integer
   */
  public int requestAvailableCapacity();
  
  /**
   * Creates a new facility object.
   * @param name String
   * @param description String
   * @param address String
   */
  public void addNewFacility(String name, String description, String address);
  
  /**
   * Adds a new room or detail to the facility.
   * @param roomNumber integer
   * @param capacity integer
   */
  public void addFacilityDetail(int roomNumber, int capacity);
  
  /**
   * Removes a facility from management.
   * @param name String
   */
  public void removeFacility(String name);
  
  /**
   * Returns a facility.
   * @param name String
   */
  public void getFacility(String name);
  
  /**
   * Shows the current facility in a string.
   * @return String
   */
  public String currentFacility();
  
  /**
   * Lists all rooms and their information.
   * @return String
   */
  public String listRooms();
  
  /**
   * Checks if facility is in use during specific interval.
   * @param date1 Date
   * @param date2 Date
   * @return true if successful
   */
  public boolean isInUseDuringInterval(Date date1, Date date2);
  
  /**
   * Assigns facility for usage in a specified date range.
   * @param date1 Date
   * @param date2 Date
   * @return true if successful
   */
  public boolean assignFacilityToUse(Date date1, Date date2);
  
  /**
   * Vacates a facility.
   */
  public void vacateFacility();
  
  /**
   * Lists all inspections.
   * @return String
   */
  public String listInspections();
  
  /**
   * lLists actual usage.
   * @return String
   */
  public String listActualUsage();
  
  /**
   * Calculated usage rate.
   * @return double
   */
  public double calcUsageRate();
  
  /**
   *  inspects a facility.
   * @return boolean
   */
  public boolean inspect();
   
  /**
   * Sets the system log. 
   * @param sysLog SystemLog
   */
  public void setSysLog(SystemLog sysLog);
   
  /**
   * Sets the facilities data. 
   * @param facilities FacilityDate
   */
  public void setFacilities(FacilityData facilities);
   
  /**
   * Called to log the creation of object.
   */
  public void log();
   
  /**
   * Closes a request.
   * @param requestNum integer
   */
  public void closeRequest(int requestNum);
   
  /**
   * Sets the parts cost.
   * @param cost BigDecimal
   * @param orderNum integer
   */
  public void setPartsCost(BigDecimal cost, int orderNum);
   
  /**
   * Sets the labor cost.
   * @param cost BigDecimal
   * @param orderNum integer
   */
  public void setLaborCost(BigDecimal cost, int orderNum);
   
  /**
   * Creates an order.
   * @param description String
   * @param requestNum integer
   */
  public void createOrder(String description, int requestNum);
   
  /**
   * Returns a list of the problems.
   * @return String
   */
  public String listFacilityProblems();
   
  /**
   * Lists the maintenance done.
   * @return List
   */
  public List<Order> listMaintenance();
  
  /**
   * Lists the maintenance open.
   * @return List
   */
  public List<MaintenanceRequest> listMaintRequests();

  /**
   * Calculates the facility down time.
   * @return long
   */
  public long calcDownTimeForFacility();
   
  /**
   * Calculates the facility problem rate.
   * @return float
   */
  public float calcProblemRateForFacility();
   
  /**
   * Calculates the cost of the facility.
   * @return BigDecimal
   */
  public BigDecimal calcMaintenanceCostForFacility();

  /**
   * Schedules the maintenance.
   * @param date1 Date
   * @param date2 Date
   * @return boolean
   */
  public boolean scheduleMaintenance(Date date1, Date date2);
   
  /**
   * Makes a maintenance request. 
   * @param problem String
   */
  public void makeFacilityMaintRequest(String problem);

  /**
   * Closes the order.
   * @param orderNum integer
   * @param requestNum integer
   */
  public void closeOrder(int orderNum, int requestNum);
}