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
        maintenance.makeFacilityMaintenanceRequest("Sink is leaking");
        maintenance.makeFacilityMaintenanceRequest("Light bulb is burnt out.");
        maintenance.makeFacilityMaintenanceRequest("Ceiling is cracking.");
        maintenance.setLaborCost(laborCost, 0);
        maintenance.setPartsCost(partsCost, 0);
    }

    @Test
    public void testCalcMaintenanceCostForFacility() {
        BigDecimal totalCost = new BigDecimal("0");
        totalCost = totalCost.add(laborCost);
        totalCost = totalCost.add(partsCost);
        assertEquals(0, totalCost.compareTo(maintenance.calcMaintenanceCostForFacility()));
    }
    
    @Test
    public void testListMaintenanceRequests() {
        assertEquals(maintenance.listMaintenanceRequests().get(0).getProblem(), "Sink is leaking");
        assertEquals(maintenance.listMaintenanceRequests().get(1).getProblem(), "Light bulb is burnt out.");
        assertEquals(maintenance.listMaintenanceRequests().get(2).getProblem(), "Ceiling is cracking.");
    }
    
    @Test
    public void testCloseOrder() {
        maintenance.closeOrder(0);
        assertTrue(maintenance.listMaintenance().get(0).getStatus());
    }

    @After
    public void tearDown() throws Exception {
        maintenance = null;
        laborCost = null;
        partsCost = null;
    }
}
