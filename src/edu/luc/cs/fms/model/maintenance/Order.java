package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;

public interface Order {
  
    public void setLaborCost(LaborCost laborCost);
    public LaborCost getLaborCost();
    public void setPartsCost(PartsCost partsCost);
    public PartsCost getPartsCost();
    public void setTotalCost(BigDecimal totalCost);
    public BigDecimal getTotalCost();
  
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
    public void setLabor(BigDecimal cost);

    /**
     * sets part cost in BigDecimal format
     * @param cost
     */
    public void setParts(BigDecimal cost);

    /**
     * @return total cost of parts and labor
     */
    public BigDecimal getCost();
}
