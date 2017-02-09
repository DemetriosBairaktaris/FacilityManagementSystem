package edu.luc.cs.comp473.project1.model.maintenance;

import java.math.BigDecimal;

public class Order {

    private String desc;
    private double orderNum;
    private boolean status;
    private Cost cost;
    private BigDecimal totalCost;
    
    public Order(String desc, double orderNum) {
        this.desc = desc;
        this.orderNum = orderNum;
        status = false;
        cost = new Cost();
        totalCost = new BigDecimal("0");
    }
    
    public String getDescription() {
        return desc;
    }
    
    public double getOrderNum() {
        return orderNum;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean getStatus() {
        return status;
    }
    
    public void setLaborCost(BigDecimal cost) {
        this.cost.setLaborCost(cost);
    }
    
    public void setPartsCost(BigDecimal cost) {
        this.cost.setPartsCost(cost);
    }
    
    public BigDecimal getCost() {
        totalCost = totalCost.add(cost.getLaborCost());
        totalCost = totalCost.add(cost.getPartsCost());
        return totalCost;
    }
}
