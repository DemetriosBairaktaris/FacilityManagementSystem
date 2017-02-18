package edu.luc.cs.comp473.project1.model.maintenance;

import java.math.BigDecimal;

import edu.luc.cs.comp473.project1.model.System.SystemLog;

/**
 * This class tracks an order created as a result of a maintenance request
 * @author TeamDK
 *
 */
public class Order {

    private String desc;
    private int orderNum;
    private boolean status;
    private Cost cost;
    private BigDecimal totalCost;
    private SystemLog sysLog;
    
    public Order(String desc, int orderNum, SystemLog sysLog) {
        this.desc = desc;
        this.orderNum = orderNum;
        status = false;
        cost = new Cost();
        totalCost = new BigDecimal("0");
        this.sysLog = sysLog;
        sysLog.logCreate(this);
    }
    
    /**
     * 
     * @return description
     */
    public String getDescription() {
        return desc;
    }
    
    /**
     * 
     * @return order number
     */
    public double getOrderNum() {
        return orderNum;
    }

    /**
     * True is complete, false is open
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    /**
     * 
     * @return status of order
     */
    public boolean getStatus() {
        return status;
    }
    
    /**
     * sets labor cost in BigDecimal format
     * @param cost
     */
    public void setLaborCost(BigDecimal cost) {
        this.cost.setLaborCost(cost);
    }
    
    /**
     * sets part cost in BigDecimal format
     * @param cost
     */
    public void setPartsCost(BigDecimal cost) {
        this.cost.setPartsCost(cost);
    }
    
    /**
     * 
     * @return total cost of parts and labor
     */
    public BigDecimal getCost() {
        totalCost = totalCost.add(cost.getLaborCost());
        totalCost = totalCost.add(cost.getPartsCost());
        return totalCost;
    }
    
    @Override
    public String toString() {
        return "Order: " + this.getOrderNum() + "\nStatus: " + this.getStatus() + "\nDescription: " + this.getDescription()
        + "\nCost: $" + this.getCost().toString();
    }
}
