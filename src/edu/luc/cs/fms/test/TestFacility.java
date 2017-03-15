package edu.luc.cs.fms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.luc.cs.fms.model.facility.*;


/**
 * 
 * @author TeamDK
 *
 */
public class TestFacility {

    private Facility facility;
    private String name = "Water Tower Campus";
    private String description = "LUC Campus located at Water Tower Place.";
    private String address = "911 Clark Street";
    ApplicationContext context ; 

    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("/META-INF/facility-context.xml");
        facility = (Facility) context.getBean("facility");
        facility.setAddress(address);
        facility.setName(name);
        facility.setDescription(description);
        
        Room room1 = (Room) context.getBean("room");
        room1.setCapacity(20);
        room1.setRoomNumber(1);
        Room room2 = (Room) context.getBean("room");
        room2.setCapacity(25);
        room2.setRoomNumber(2);
        Room room3 = (Room) context.getBean("room");
        room3.setCapacity(20);
        room3.setRoomNumber(11);
        facility.addFacilityDetail(room1);
        facility.addFacilityDetail(room2);
        facility.addFacilityDetail(room3);
    }

    @After
    public void tearDown() throws Exception {
        facility = null;
    }

    @Test
    public void testGetName() {
        assertEquals("Water Tower Campus", facility.getName());
    }

    @Test
    public void testGetDescription() {
        assertEquals(description, facility.getDescription());
    }

    @Test
    public void testGetFacilityInformation() {
        assertEquals(name + ":  " + description + "\n" + "Address:  " + address + "\n" + "Available Capacity:  "
                + facility.requestAvailableCapacity(), facility.getFacilityInformation());
    }

    @Test
    public void testRequestAvailableCapacity() {
        assertEquals(65, facility.requestAvailableCapacity());
        Room newRoom = (Room) context.getBean("room");
        newRoom.setCapacity(5);
        newRoom.setRoomNumber(5);
        facility.addFacilityDetail(newRoom);
        assertEquals(70, facility.requestAvailableCapacity());
    }

    @Test
    public void testAddFacilityDetail() {
        assertEquals(3, facility.getRooms().size());
        Room newRoom = (Room) context.getBean("room");
        newRoom.setRoomNumber(5);
        newRoom.setCapacity(13);
        facility.addFacilityDetail(newRoom);
        assertEquals(4, facility.getRooms().size());
    }

    @Test
    public void testIsInUseDuringInterval() {
        Date currentDate = new Date();
        Date one, two, three;
        one = new Date(currentDate.getTime() + 30000);
        two = new Date(currentDate.getTime() + 40000);
        three = new Date(currentDate.getTime() + 31000);
        assertFalse(facility.isInUseDuringInterval(one, two));
        facility.assignFacilityToUse(one, two);
        assertTrue(facility.isInUseDuringInterval(one, two));
        assertTrue(facility.isInUseDuringInterval(one, three));
    }

    @Test
    public void testAssignFacilityToUse() {
        Date currentDate = new Date();
        Date one = new Date(currentDate.getTime() + 200000);
        Date two = new Date(currentDate.getTime() + 300000);
        assertTrue(facility.assignFacilityToUse(one, two));
        assertFalse(facility.assignFacilityToUse(new Date(currentDate.getTime() - 20000), two));
        assertFalse(facility.assignFacilityToUse(one, one));
    }

    @Test
    public void testListActualUsage() {
        Date currentDate = new Date();
        Date one = new Date(currentDate.getTime() + 30000);
        Date two = new Date(currentDate.getTime() + 40000);
        Date three = new Date(currentDate.getTime() + 50000);
        Date four = new Date(currentDate.getTime() + 60000);
        facility.assignFacilityToUse(one, two);
        facility.assignFacilityToUse(three, four);
        assertEquals("Usage Dates:\n" + one.toString() + " - " + two.toString() + "\n" + three.toString() + " - "
                + four.toString() + "\n", facility.listActualUsage());
    }

    @Test
    public void testCalcUsageRate() {
        // Simple Case: 1 Day : should be 1/365
        Date one, two, three;
        Calendar c = new GregorianCalendar();
        c.set(2018, 0, 1);
        one = c.getTime();
        c.set(2018, 0, 2);
        two = c.getTime();
        facility.assignFacilityToUse(one, two);
        assertEquals((1.0 / 365), facility.calcUsageRate(), 0.005);
        // Complex Case: OverLapping Intervals
        c.set(2018, 2, 30);
        one = c.getTime();
        c.set(2018, 3, 10);
        two = c.getTime();
        c.set(2018, 1, 20);
        three = c.getTime();
        facility.assignFacilityToUse(one, two);
        facility.assignFacilityToUse(three, one);
        facility.assignFacilityToUse(three, two); // total should be 2-20-2018
                                                  // -- 4-10-2018
        assertEquals((70560.0 / 525600.0), facility.calcUsageRate(), 0.005);
    }

    @Test
    public void testVacateFacility() throws Exception {
        int initialCapacity = facility.requestAvailableCapacity();
        facility.vacateFacility();
        assertEquals(initialCapacity, facility.requestAvailableCapacity());
        int currentCapacity = facility.requestAvailableCapacity();
        assertTrue(initialCapacity == currentCapacity);
        facility.vacateFacility();
        currentCapacity = facility.requestAvailableCapacity();
        assertEquals(currentCapacity, initialCapacity);
    }

    @Test
    public void testListInspections() {
        facility.inspect() ; 
        facility.inspect() ; 
        Date d = new Date();
        assertEquals("Inspections:\n" + d + ":  passed\n" + d + ":  passed\n",
                facility.listInspections());
    }
}
