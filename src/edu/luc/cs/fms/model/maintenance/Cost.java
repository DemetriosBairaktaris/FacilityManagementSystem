package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;

/**
 * This class handles a cost associated with an order. All costs are in Big
 * Decimal format for accurate money calculations
 * 
 * @author TeamDK
 *
 */
public class Cost {

    private BigDecimal partsCost;
    private BigDecimal laborCost;

    public Cost() {
        partsCost = new BigDecimal("0");
        laborCost = new BigDecimal("0");
    }

    /**
     * Sets the labor cost
     * 
     * @param cost
     */
    public void setLaborCost(BigDecimal cost) {
        laborCost = cost;
    }

    /**
     * retrieves the labor cost
     * 
     * @return laborCost
     */
    public BigDecimal getLaborCost() {
        return laborCost;
    }

    /**
     * sets parts cost
     * 
     * @param cost
     */
    public void setPartsCost(BigDecimal cost) {
        partsCost = cost;
    }

    /**
     * retrieves parts cost
     * 
     * @return partsCost
     */
    public BigDecimal getPartsCost() {
        return partsCost;
    }
}
