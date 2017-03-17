package edu.luc.cs.fms.model.maintenance;

import edu.luc.cs.fms.model.system.SystemLog;

public interface MaintenanceRequest {

  public void setOpenOrders(int openOrders);

  /**
   * Gets the status.
   * @return status boolean
   */
  public boolean getStatus();

  /**
   * Sets the status of the request.
   * @param status boolean
   */
  public void setStatus(boolean status);


  /**
   * Gets the problem.
   * @return String
   */
  public String getProblem();

  /**
   * Gets the request number.
   * @return request integer
   */
  public int getRequestNum();

  /**
   * Gets the open order number.
   * @return integer of orders
   */
  public int getOpenOrders();

  /**
   * Adds an open order.
   */
  public void addOpenOrder();

  /**
   * Removes an order once closed.
   */
  public void removeOpenOrder();

  /**
   * Logs the object.
   */
  public void log();

  /**
   * Sets the problem.
   * @param problem String
   */
  public void setProblem(String problem);

  /**
   * Sets the request number.
   * @param requestNum integer
   */
  public void setRequestNum(int requestNum);
  
  /**
   * 
   * @param sysLog
   */
  void setSysLog(SystemLog sysLog);
}