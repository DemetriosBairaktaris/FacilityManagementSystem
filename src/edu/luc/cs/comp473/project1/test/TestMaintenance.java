package edu.luc.cs.comp473.project1.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.comp473.project1.model.maintenance.Maintenance;

public class TestMaintenance {

    private Maintenance maintenance;
    private BigDecimal laborCost;
    private BigDecimal partsCost;
    private Date date1, date2, date3, date4;
    
    @Before
    public void setUp() throws Exception {
        maintenance = new Maintenance();
        laborCost = new BigDecimal("343.87");
        partsCost = new BigDecimal("210.45");
        date1 = new Date(1491022800000L);
        date2 = new Date(1491368400000L);
        date3 = new Date(1491109200000L);
        date4 = new Date(1491282000000L);
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
        maintenance.closeOrder(1);
        maintenance.closeOrder(2);
        assertEquals(maintenance.listMaintenance().size(), 3);
    }
    
    @Test
    public void testScheduleMaintenancec() {
        assertTrue(maintenance.scheduleMaintenance(date1, date2));
        assertFalse(maintenance.scheduleMaintenance(date3, date4));
    }

    @After
    public void tearDown() throws Exception {
        maintenance = null;
        laborCost = null;
        partsCost = null;
        date1 = null;
        date2 = null;
        date3 = null;
        date4 = null;
    }
}
