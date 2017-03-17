package edu.luc.cs.fms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.luc.cs.fms.model.facility.Room;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This class test the room class.
 * @author TeamDK
 *
 */
public class TestRoom {

  private Room room;
  private int roomNum;
  private int capacity;
  private static ApplicationContext context;

  /**
   * runs once before all tests
   */
  @BeforeClass
  public static void setUpClass() {
      context = new ClassPathXmlApplicationContext("/META-INF/facility-context.xml"); 
  }
  
  /**
   * runs once after all tests
   */
  @AfterClass
  public static void afterClass() {
      ((ConfigurableApplicationContext)context).close();
  }
  /**
   * Sets up the test.
   * @throws Exception ignored
   */
  @Before
  public void setUp() throws Exception {
    roomNum = 101;
    capacity = 40;
    room = (Room) context.getBean("room");
    room.setRoomNumber(roomNum);
    room.setCapacity(capacity);
  }

  /**
   * This tears it down.
   * @throws Exception ignored
   */
  @After
  public void tearDown() throws Exception {
    room = null;
  }

  @Test
  public void testGetRoomNumber() {
    assertEquals(room.getRoomNumber(), roomNum);
  }


  @Test
  public void testGetAvailableCapacity() throws Exception {
    int initCapacity = room.getAvailableCapacity();
    assertTrue(initCapacity == capacity);
  }
}