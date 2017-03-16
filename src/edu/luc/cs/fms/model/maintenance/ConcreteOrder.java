package edu.luc.cs.fms.model.maintenance;

import edu.luc.cs.fms.model.system.SystemLog;

import java.math.BigDecimal;

/**
 * This class tracks an order created as a result of a maintenance request.
 * 
 * @author TeamDK
 *
 */
public class ConcreteOrder implements Order {

  private String description;
  private int orderNum;
  private boolean status;
  private Cost partsCost;
  private Cost laborCost;
  private BigDecimal totalCost;
  private SystemLog sysLog;

  public ConcreteOrder(SystemLog sysLog) {
    this.sysLog = sysLog;
  }

  @Override
  public void log() {
    sysLog.logCreate(this);
  }

  @Override
  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public void setOrderNum(int orderNum) {
    this.orderNum = orderNum;
  }

  @Override
  public void setLaborCost(Cost laborCost) {
    this.laborCost = laborCost;
  }
  
  @Override
  public void setPartsCost(Cost partsCost) {
    this.partsCost = partsCost;
  }
  
  @Override
  public void setTotalCost(BigDecimal totalCost) {
    this.totalCost = totalCost;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public int getOrderNum() {
    return orderNum;
  }

  @Override
  public void setStatus(boolean status) {
    this.status = status;
  }

  @Override
  public boolean getStatus() {
    return status;
  }

  @Override
  public void setLabor(BigDecimal cost) {
    laborCost.setCost(cost);
  }

  @Override
  public void setParts(BigDecimal cost) {
    partsCost.setCost(cost);
  }

  @Override
  public BigDecimal getCost() {
    totalCost = totalCost.add(partsCost.getCost());
    totalCost = totalCost.add(laborCost.getCost());
    return totalCost;
  }

  @Override
  public String toString() {
    return "Order: " + this.getOrderNum() + "\nStatus: " + this.getStatus() + "\nDescription: "
        + this.getDescription() + "\nCost: $" 
        + laborCost.getCost().add(partsCost.getCost()).toString();
  }
}