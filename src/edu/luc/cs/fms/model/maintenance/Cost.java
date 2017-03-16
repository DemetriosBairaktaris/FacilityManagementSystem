package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;

public interface Cost {

  /**
   * Sets the cost.
   * @param cost BigDecimal cost
   */
  public void setCost(BigDecimal cost);

  /**
   * Gets the cost.
   * @return cost BigDecimal cost
   */
  public BigDecimal getCost();
}
