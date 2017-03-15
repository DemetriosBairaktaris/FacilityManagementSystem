package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;

import edu.luc.cs.fms.model.system.SystemLog;

/**
 * This class tracks an order created as a result of a maintenance request
 * 
 * @author TeamDK
 *
 */
public class ConcreteOrder implements Order{

    private String description;
    private int orderNum;
    private boolean status;
    private PartsCost partsCost;
    private LaborCost laborCost;
    private BigDecimal totalCost;
    private SystemLog sysLog;

    public ConcreteOrder(SystemLog sysLog) {
        //this.desc = desc;
        //this.orderNum = orderNum;
        //status = false;
        //partsCost = new PartsCost();
        //laborCost = new LaborCost();
        //totalCost = new BigDecimal("0");
        //sysLog.logCreate(this);
        this.sysLog = sysLog;
    }
    
    public void log() {
      sysLog.logCreate(this);
    }
    
    public void setDescription(String description) {
      this.description = description;
    }
    
    public void setOrderNum(int orderNum) {
      this.orderNum = orderNum;
    }
    
    public void setLaborCost(LaborCost laborCost) {
      this.laborCost = laborCost;
    };
    public LaborCost getLaborCost() {
      return laborCost;
    };
    public void setPartsCost(PartsCost partsCost) {
      this.partsCost = partsCost;
    };
    public PartsCost getPartsCost() {
      return partsCost;
    };
    public void setTotalCost(BigDecimal totalCost) {
      this.totalCost = totalCost;
    };
    public BigDecimal getTotalCost() {
      return totalCost;
    };
    

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return order number
     */
    public int getOrderNum() {
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
     * @return status of order
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * sets labor cost in BigDecimal format
     * @param cost
     */
    public void setLabor(BigDecimal cost) {
        laborCost.setCost(cost);
    }

    /**
     * sets part cost in BigDecimal format
     * @param cost
     */
    public void setParts(BigDecimal cost) {
        partsCost.setCost(cost);
    }

    /**
     * @return total cost of parts and labor
     */
    public BigDecimal getCost() {
        //BigDecimal totalCost = (BigDecimal) 
        totalCost = totalCost.add(partsCost.getCost());
        totalCost = totalCost.add(laborCost.getCost());
        return totalCost;
    }

    @Override
    public String toString() {
        return "Order: " + this.getOrderNum() + "\nStatus: " + this.getStatus() + "\nDescription: "
                + this.getDescription() + "\nCost: $" + laborCost.getCost().add(partsCost.getCost()).toString();
    }
}
