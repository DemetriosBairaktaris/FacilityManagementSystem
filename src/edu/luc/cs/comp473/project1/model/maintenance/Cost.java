package edu.luc.cs.comp473.project1.model.maintenance;

import java.math.BigDecimal;

public class Cost {

    private BigDecimal partsCost;
    private BigDecimal laborCost;
    
    public Cost() {
        partsCost = new BigDecimal("0");
        laborCost = new BigDecimal("0");
    }
    
    public void setLaborCost(BigDecimal cost) {
        laborCost = cost;
    }
    
    public BigDecimal getLaborCost() {
        return laborCost;
    }
    
    public void setPartsCost(BigDecimal cost) {
        partsCost = cost;
    }
    
    public BigDecimal getPartsCost() {
        return partsCost;
    }
    
}
