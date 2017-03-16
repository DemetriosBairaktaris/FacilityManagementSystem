package edu.luc.cs.fms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.luc.cs.fms.model.maintenance.Maintenance;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class tests the maintenance module.
 * @author TeamDK
 *
 */
public class TestMaintenance {

  private Maintenance maintenance;
  private BigDecimal laborCost;
  private BigDecimal partsCost;
  private Date date1;
  private Date date2;
  private Date date3;
  private Date date4;
  private ApplicationContext context;

  /**
   * Provides the setup.
   * @throws Exception ignored
   */
  @Before
  public void setUp() throws Exception {
    context = new ClassPathXmlApplicationContext("/META-INF/maintenance-context.xml");
    maintenance = (Maintenance) context.getBean("maintenance");
    laborCost = new BigDecimal("343.87");
    partsCost = new BigDecimal("210.45");
    date1 = new Date(1491022800000L); // April 1, 2017
    date2 = new Date(1491368400000L); // April 5, 2017
    date3 = new Date(1491109200000L); // April 2, 2017
    date4 = new Date(1491282000000L); // April 4, 2017
    maintenance.makeFacilityMaintRequest("Sink is leaking");
    maintenance.makeFacilityMaintRequest("Light bulb is burnt out.");
    maintenance.makeFacilityMaintRequest("Ceiling is cracking.");
    maintenance.createOrder("Repair sink plumbing.", 0);
    maintenance.createOrder("Replace light bulb.", 1);
    maintenance.createOrder("Patch ceiling crack.", 2);
    maintenance.setLaborCost(laborCost, 0);
    maintenance.setPartsCost(partsCost, 0);
  }

  /**
   * Destroys the setup.
   * @throws Exception ignored
   */
  @After
  public void tearDown() throws Exception {
    ((ConfigurableApplicationContext)context).close();
    maintenance = null;
    laborCost = null;
    partsCost = null;
    date1 = null;
    date2 = null;
    date3 = null;
    date4 = null;
  }

  @Test
  public void testScheduleMaintenancec() {
    assertTrue(maintenance.scheduleMaintenance(date1, date2));
    assertFalse(maintenance.scheduleMaintenance(date3, date4));
  }

  @Test
  public void testCalcMaintenanceCostForFacility() {
    BigDecimal totalCost = new BigDecimal("0");
    totalCost = totalCost.add(laborCost);
    totalCost = totalCost.add(partsCost);
    assertEquals(0, totalCost.compareTo(maintenance.calcMaintenanceCostForFacility()));
  }

  @Test
  public void testCloseOrder() {
    maintenance.closeOrder(0, 0);
    assertTrue(maintenance.listMaintenance().get(0).getStatus());
    maintenance.closeOrder(1, 1);
    maintenance.closeOrder(2, 2);
    assertEquals(maintenance.listMaintenance().size(), 3);
  }

  @Test
  public void testCloseRequests() {
    maintenance.closeRequest(0);
    assertFalse(maintenance.listMaintRequests().get(0).getStatus());
    maintenance.closeOrder(0, 0);
    maintenance.closeRequest(0);
    assertTrue(maintenance.listMaintRequests().get(0).getStatus());
  }

  @Test
  public void testCalcProblemRateForFacility() {
    float num = (float) (3.0 / 365.0);
    assertEquals(num, maintenance.calcProblemRateForFacility(), 0.0005);
  }

  @Test
  public void testCalcDownTimeForFacility() {
    assertTrue(maintenance.scheduleMaintenance(date1, date2));
    assertEquals(4L, maintenance.calcDownTimeForFacility());
  }

  @Test
  public void testListMaintenanceRequests() {
    assertEquals(maintenance.listMaintRequests().get(0).getProblem(), "Sink is leaking");
    assertEquals(maintenance.listMaintRequests().get(1).getProblem(), "Light bulb is burnt out.");
    assertEquals(maintenance.listMaintRequests().get(2).getProblem(), "Ceiling is cracking.");
  }

  @Test
  public void testListMaintenance() {
    assertEquals(maintenance.listMaintenance().size(), 0);
    maintenance.closeOrder(0, 0);
    maintenance.closeOrder(1, 1);
    maintenance.closeOrder(2, 2);
    assertEquals(maintenance.listMaintenance().size(), 3);
    assertEquals(maintenance.listMaintenance().get(0).getDescription(), "Repair sink plumbing.");
  }

  @Test
  public void testListFacilityProblems() {
    String test = "Facility Problems:\n" + "Sink is leaking\n" + "Light bulb is burnt out.\n"
        + "Ceiling is cracking.\n";
    assertEquals(test, maintenance.listFacilityProblems());
  }
}