package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;

public class LaborCost implements Cost{

    private BigDecimal cost;
    
    public LaborCost() {
        cost = new BigDecimal("0");
    }
    
    @Override
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

}
