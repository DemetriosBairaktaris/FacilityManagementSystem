package edu.luc.cs.comp473.project1.model.maintenance;

public class Order {

    private String desc;
    private double orderNum;
    private String technician;
    private boolean status;
    
    public Order(String desc, double orderNum, String technician) {
        this.desc = desc;
        this.orderNum = orderNum;
        this.technician = technician;
        status = false;
    }
    
    public String getDescription() {
        return desc;
    }
    
    public double getOrderNum() {
        return orderNum;
    }
    
    public String getTechnician() {
        return technician;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public boolean getStatus() {
        return status;
    }
}
