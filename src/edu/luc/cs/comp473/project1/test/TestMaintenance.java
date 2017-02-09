package edu.luc.cs.comp473.project1.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.comp473.project1.model.maintenance.Maintenance;

public class TestMaintenance {

    private Maintenance maintenance;
    private BigDecimal laborCost;
    private BigDecimal partsCost;
    
    @Before
    public void setUp() throws Exception {
        maintenance = new Maintenance();
        laborCost = new BigDecimal("343.87");
        partsCost = new BigDecimal("210.45");
    }

    @Test
    public void testCalcMaintenanceCostForFacility() {
        maintenance.makeFacilityMaintenanceRequest("Toilet needs replacing.");
        maintenance.setLaborCost(laborCost, 0);
        maintenance.setPartsCost(partsCost, 0);
        BigDecimal totalCost = new BigDecimal("0");
        totalCost = totalCost.add(laborCost);
        totalCost = totalCost.add(partsCost);
        assertEquals(0, totalCost.compareTo(maintenance.calcMaintenanceCostForFacility()));
    }

    @After
    public void tearDown() throws Exception {
        maintenance = null;
    }
}
