package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface Maintenance {

  /**
   * Sets the log object.
   * @param log Log
   */
  public void setLog(Log log);
  
  /**
   * Sets the request object list.
   * @param requests list
   */
  public void setRequests(List<MaintenanceRequest> requests);
  
  /**
   * Sets the order object list.
   * @param orders list
   */
  public void setOrders(List<Order> orders);
  
  /**
   * Sets the schedule object.
   * @param schedule Schedule
   */
  public void setSchedule(Schedule schedule);
  
  /**
   * Sets the cost object.
   * @param cost BigDecimal
   */
  public void setCost(BigDecimal cost);

  /**
   * Sets the request number.
   * @param numRequests integer
   */
  public void setNumRequests(int numRequests);

  /**
   * Makes a maintenance request.
   * @param problem String
   */
  public void makeFacilityMaintRequest(String problem);

  /**
   * Schedules maintenance for specified dates.
   * @param start Date
   * @param end Date
   * @return boolean true if successful
   */
  public boolean scheduleMaintenance(Date start, Date end);

  /**
   * Calculates total maintenance cost.
   * @return BigDecimal object
   */
  public BigDecimal calcMaintenanceCostForFacility();

  /**
   * Calculates problem rate per 365 days.
   * @return float number
   */
  public float calcProblemRateForFacility();

  /**
   * Calculates down time for facility.
   * @return long number
   */
  public long calcDownTimeForFacility();

  /**
   * Retrieves a list of maintenance requests.
   * @return List of maintenance requests
   */
  public List<MaintenanceRequest> listMaintRequests();

  /**
   * Retrieves list of maintenance performed.
   * @return list of orders
   */
  public List<Order> listMaintenance();

  /**
   * Lists the problems in the maintenance requests.
   * @return String of facility problems
   */
  public String listFacilityProblems();

  /**
   * Creates an order and assigns it to a maintenance request.
   * @param description String
   * @param requestNum integer
   */
  public void createOrder(String description, int requestNum);

  /**
   * Sets labor cost for an order.
   * @param cost BigDecimal
   * @param orderNum integer
   */
  public void setLaborCost(BigDecimal cost, int orderNum);

  /**
   * Sets parts cost for an order.
   * @param cost BigDecimal
   * @param orderNum integer
   */
  public void setPartsCost(BigDecimal cost, int orderNum);

  /**
   * Closes maintenance request if it has no open orders.
   * @param requestNum integer
   */
  public void closeRequest(int requestNum);

  /**
   * Closes an order and removes it from maintenance request.
   * @param orderNum integer
   * @param requestNum integer
   */
  public void closeOrder(int orderNum, int requestNum);
}