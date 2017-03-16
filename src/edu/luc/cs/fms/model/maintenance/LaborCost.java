package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;

/**
 * This class handles a cost associated with an order. All costs are in Big
 * Decimal format for accurate money calculations
 * 
 * @author TeamDK
 *
 */
public class LaborCost implements Cost {

  private BigDecimal cost;

  public LaborCost() {}

  @Override
  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }

  @Override
  public BigDecimal getCost() {
    return cost;
  }
}