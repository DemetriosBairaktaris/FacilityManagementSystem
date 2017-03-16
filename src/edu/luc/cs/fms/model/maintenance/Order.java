package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;

public interface Order {
  
  /**
   * Logs the creation.
   */
  public void log();

  /**
   * Sets laborCost object.
   * @param laborCost LaborCost
   */
  public void setLaborCost(Cost laborCost);
  
  /**
   * Sets PartsCost object.
   * @param partsCost PartsCost
   */
  public void setPartsCost(Cost partsCost);
  
  /**
   * Sets total cost.
   * @param totalCost BigDecimal 
   */
  public void setTotalCost(BigDecimal totalCost);

  /**
   * Gets the description.
   * @return description String
   */
  public String getDescription();

  /**
   * Gets the order number.
   * @return order integer
   */
  public int getOrderNum();

  /**
   * True is complete, false is open.
   * @param status boolean
   */
  public void setStatus(boolean status);

  /**
   * Gets the status.
   * @return status of order
   */
  public boolean getStatus();

  /**
   * Sets labor cost in BigDecimal format.
   * @param cost BigDecimal
   */
  public void setLabor(BigDecimal cost);

  /**
   * Sets part cost in BigDecimal format.
   * @param cost BigDecimal
   */
  public void setParts(BigDecimal cost);

  /**
   * Returns total cost.
   * @return BigDecimal object
   */
  public BigDecimal getCost();

  /**
   * Sets the description.
   * @param description String
   */
  public void setDescription(String description);

  /**
   * Sets the order number.
   * @param orderNum integer
   */
  public void setOrderNum(int orderNum);
}