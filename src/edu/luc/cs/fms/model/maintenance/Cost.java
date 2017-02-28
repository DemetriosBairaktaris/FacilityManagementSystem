package edu.luc.cs.fms.model.maintenance;

import java.math.BigDecimal;

public interface Cost {

    /**
     * @param cost
     */
    public void setCost(BigDecimal cost);

    /**
     * @return cost
     */
    public BigDecimal getCost();
}
