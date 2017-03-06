package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;

public interface Order {
    /**
     * @return description
     */
    public String getDescription();

    /**
     * @return order number
     */
    public int getOrderNum();

    /**
     * True is complete, false is open
     * @param status
     */
    public void setStatus(boolean status);

    /**
     * @return status of order
     */
    public boolean getStatus();

    /**
     * sets labor cost in BigDecimal format
     * @param cost
     */
    public void setLaborCost(BigDecimal cost);

    /**
     * sets part cost in BigDecimal format
     * @param cost
     */
    public void setPartsCost(BigDecimal cost);

    /**
     * @return total cost of parts and labor
     */
    public BigDecimal getCost();
}
