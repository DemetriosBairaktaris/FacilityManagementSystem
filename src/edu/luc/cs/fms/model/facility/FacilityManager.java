package edu.luc.cs.fms.model.facility;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import edu.luc.cs.fms.dal.ConcreteFacilityDAO;
import edu.luc.cs.fms.model.maintenance.ConcreteMaintenanceRequest;
import edu.luc.cs.fms.model.maintenance.ConcreteOrder;
import edu.luc.cs.fms.model.system.SystemLog;

/**
 * 
 * @author TeamDK
 *
 */
public interface FacilityManager {

    public ConcreteFacilityDAO getFacilities();
  
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
     
     /**
      * 
      * @param sysLog
      */
     public void setSysLog(SystemLog sysLog);
     
     /**
      * 
      * @param facilities
      */
     public void setFacilities(ConcreteFacilityDAO facilities);
     
     /**
      * called to log the creation of object
      */
     void log();
     
     /**
      * 
      * @param requestNum
      */
     void closeRequest(int requestNum);
     
     /**
      * 
      * @param cost
      * @param orderNum
      */
     void setPartsCost(BigDecimal cost, int orderNum);
     
     /**
      * 
      * @param cost
      * @param orderNum
      */
     void setLaborCost(BigDecimal cost, int orderNum);
     
     /**
      * 
      * @param desc
      * @param requestNum
      */
     void createOrder(String desc, int requestNum);
     
     /**
      * 
      * @return
      */
     String listFacilityProblems();
     
     /**
      * 
      * @return
      */
     List<ConcreteOrder> listMaintenance();
             
     /**
      * 
      * @return
      */
     List<ConcreteMaintenanceRequest> listMaintRequests();
     
     /**
      * 
      * @return
      */
     long calcDownTimeForFacility();
     
     /**
      * 
      * @return
      */
     float calcProblemRateForFacility();
     
     /**
      * 
      * @return
      */
     BigDecimal calcMaintenanceCostForFacility();
     
     /**
      * 
      * @param date1
      * @param date2
      * @return
      */
     boolean scheduleMaintenance(Date date1, Date date2);
     
     /**
      * 
      * @param problem
      */
     void makeFacilityMaintRequest(String problem);
     
     /**
      * 
      * @param orderNum
      * @param requestNum
      */
     void closeOrder(int orderNum, int requestNum);
}
