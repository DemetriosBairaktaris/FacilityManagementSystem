package edu.luc.cs.fms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import edu.luc.cs.fms.model.facility.FacilityManager;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * This class tests the facility manager.
 * @author TeamDK
 *
 */
public class TestFacilityManager {

  private FacilityManager manager;
  private String name = "Cuneo";
  private String desc = "Building Containing classrooms";
  private String address = "23 west loyola ave";
  private Calendar cal;
  private static ApplicationContext context; 

  /**
   * runs once before all test
   */
  @BeforeClass
  public static void setUpClass() {
    context = new ClassPathXmlApplicationContext("/META-INF/facility-context.xml");
  }
  
  /*
   * runs after all tests are done
   */
  @AfterClass
  public static void afterClass(){
      ((ConfigurableApplicationContext)context).close();
  }

  /**
   * Sets up the test.
   * @throws Exception ignored
   */
  @Before
    public void setUp() throws Exception {
    manager = (FacilityManager) context.getBean("manager");
    manager.addNewFacility(name, desc, address);
    cal = new GregorianCalendar();
  }

  /**
   * Destroys the test.
   * @throws Exception ignored
   */
  @After
  public void tearDown() throws Exception {
    manager = null;
    cal = null;
  }

  @Test
  public void testListFacilities() {
    assertEquals("Facilities:\nid:  " + name.hashCode() + "\n" + name 
        + ":  " + desc + "\n" + "Address:  " + address
        + "\n", manager.listFacilities());
  }

  @Test
  public void testRemoveFacilities() {
    manager.removeFacility(name);
    assertEquals("Facilities:\nNone", manager.listFacilities());
  }

  @Test
  public void testAddRoomToFacility() {
    int roomNumber = 1;
    int capacity = 20;
    manager.getFacility(name);
    manager.addFacilityDetail(roomNumber, capacity);
    assertEquals("Rooms:\nRoom 1 - Capacity 20\n", manager.listRooms());
  }

  @Test
  public void testScheduleMaintenance() {
    manager.getFacility(name);
    cal.set(2018, 0, 1);
    Date date1 = cal.getTime();
    cal.set(2018, 1, 1);
    Date date2 = cal.getTime();
    assertTrue(manager.scheduleMaintenance(date1, date2));
    cal.set(1999, 1, 2);
    date1 = cal.getTime();
    cal.set(1999, 2, 3);
    date2 = cal.getTime();
    assertFalse(manager.scheduleMaintenance(date1, date2));
  }

  @Test
  public void testCalcMaintenanceCostForFacility() {
    manager.getFacility(name);
    String problem = "Dirty Windows";
    manager.makeFacilityMaintRequest(problem);
    manager.createOrder("Clean Windows", 0);
    manager.setLaborCost(BigDecimal.valueOf(20), 0);
    manager.setPartsCost(BigDecimal.valueOf(5), 0);
    cal.set(2018, 1, 8);
    Date d1 = cal.getTime();
    cal.set(2018, 3, 8);
    Date d2 = cal.getTime();
    manager.scheduleMaintenance(d1, d2);
    assertEquals(25.00, manager.calcMaintenanceCostForFacility().doubleValue(), 0.005);
  }

  @Test
  public void testCalcProblemRateForFacility() {
    manager.getFacility(name);
    manager.makeFacilityMaintRequest("1");
    manager.makeFacilityMaintRequest("2");
    System.out.println(manager.listMaintRequests());
    assertEquals(2.0 / 365.0, manager.calcProblemRateForFacility(), 0.00005);
  }

  @Test
  public void testCalcDownTimeForFacility() {
    manager.getFacility(name);
    cal.set(2018, 1, 8);
    Date date1 = cal.getTime();
    cal.set(2018, 3, 8);
    Date date2 = cal.getTime();
    manager.scheduleMaintenance(date1, date2);
    assertEquals(TimeUnit.MILLISECONDS.toDays((date2.getTime() 
        - date1.getTime())), manager.calcDownTimeForFacility());
  }

  @Test
  public void testListFacilityProblems() {
    manager.getFacility(name);
    assertEquals("No facility problems.", manager.listFacilityProblems());
    String problem1 = "Bathroom is flooded";
    String problem2 = "Clock is crooked";
    manager.makeFacilityMaintRequest(problem1);
    manager.makeFacilityMaintRequest(problem2);
    assertEquals("Facility Problems:\n" + problem1 + "\n" 
        + problem2 + "\n", manager.listFacilityProblems());
  }
}