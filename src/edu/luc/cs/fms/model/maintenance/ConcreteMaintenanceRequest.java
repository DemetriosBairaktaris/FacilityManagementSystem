package edu.luc.cs.fms.model.maintenance;

import edu.luc.cs.fms.model.system.SystemLog;

/**
 * This class creates MaintenanceRequest objects.
 * 
 * @author TeamDK
 *
 */
public class ConcreteMaintenanceRequest implements MaintenanceRequest {

  private boolean status;
  private String problem;
  private int requestNum;
  private int openOrders;
  private SystemLog sysLog;

  public ConcreteMaintenanceRequest() {}

  @Override
  public void log() {
    sysLog.logCreate(this);
  }
  
  @Override 
  public void setSysLog(SystemLog sysLog){
      this.sysLog  = sysLog ; 
  }

  @Override
  public void setProblem(String problem) {
    this.problem = problem;
  }

  @Override
  public void setRequestNum(int requestNum) {
    this.requestNum = requestNum;
  }
  
  @Override
  public void setOpenOrders(int openOrders) {
    this.openOrders = openOrders;
  }

  @Override
  public boolean getStatus() {
    return status;
  }

  @Override
  public void setStatus(boolean status) {
    this.status = status;
  }

  @Override
  public String getProblem() {
    return this.problem;
  }

  @Override
  public int getRequestNum() {
    return requestNum;
  }

  @Override
  public int getOpenOrders() {
    return openOrders;
  }

  @Override
  public void addOpenOrder() {
    openOrders++;
  }

  @Override
  public void removeOpenOrder() {
    openOrders--;
  }

  @Override
  public String toString() {
    return "Maintenance Request #" + this.getRequestNum() + "\nStatus: " 
        + this.getStatus() + "\nProblem: " + this.getProblem();
  }
}