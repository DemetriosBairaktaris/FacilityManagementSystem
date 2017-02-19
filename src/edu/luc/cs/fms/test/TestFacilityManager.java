package edu.luc.cs.fms.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.fms.model.facility.ConcreteFacilityManager;
import edu.luc.cs.fms.model.facility.FacilityManager;

public class TestFacilityManager {
    private FacilityManager manager ;
    private String name = "Cuneo";
    private String desc = "Building Containing classrooms" ;
    private String address = "23 west loyola ave";
    private Calendar c ;
    
    @Before
    public void setUp() throws Exception {
        manager = new ConcreteFacilityManager();
        manager.addNewFacility(name, desc, address);
        c = new GregorianCalendar();
        
    }

    @After
    public void tearDown() throws Exception {
        manager = null ; 
    }

    @Test
    public void testListFacilities() {
        assertEquals("Facilities:\nid:  "+name.hashCode()+"\n"+name+":  "+desc+"\n"+
                "Address:  "+address+"\n"
                ,manager.listFacilities());
    }
    
    @Test 
    public void testRemoveFacilities(){
        manager.removeFacility(name);
        assertEquals("Facilities:\nNone",manager.listFacilities());
    }
    
    @Test
    public void testAddRoomToFacility(){
        int roomNumber = 1;
        int capacity=20 ; 
        manager.getFacility(name);
        manager.addRoomToFacility(roomNumber, capacity);
        
        
        assertEquals("Rooms:\nRoom 1 - Capacity 20\n"
               ,manager.listRooms());
    }
    @Test
    public void testScheduleMaintenance(){
        manager.getFacility(name);
        Date date1,date2;
        c.set(2018, 0, 1);
        date1 = c.getTime();
        c.set(2018,1,1);
        date2 = c.getTime();
        assertTrue(manager.scheduleMaintenance(date1, date2));
        c.set(1999, 1, 2);
        date1 = c.getTime();
        c.set(1999,2,3);
        date2 = c.getTime();
        assertFalse(manager.scheduleMaintenance(date1, date2));
    }
    
    @Test
    public void TestCalcMaintenanceCostForFacility(){
        String problem = "Dirty Windows";
        Date d1,d2;
        c.set(2018,1,8);
        d1 = c.getTime();
        c.set(2018,3,8);
        d2 = c.getTime();
        
        manager.getFacility(name);
        manager.makeFacilityMaintRequest(problem);
        manager.createOrder("Clean Windows", 0);
        manager.setLaborCost(new BigDecimal(20), 0);
        manager.setPartsCost(new BigDecimal(5.00), 0);
        manager.scheduleMaintenance(d1, d2);
        assertEquals(25.00,manager.calcMaintenanceCostForFacility().doubleValue(),0.005);
        
    }
    
    @Test
    public void testCalcProblemRateForFacility(){
       manager.getFacility(name);
       manager.makeFacilityMaintRequest("1");
       manager.makeFacilityMaintRequest("2");
       System.out.println(manager.listMaintRequests());
       assertEquals(2.0/365.0,manager.calcProblemRateForFacility(),0.00005);
        
    }
    
    @Test
    public void testCalcDownTimeForFacility(){
        manager.getFacility(name);
        Date date1,date2;
        c.set(2018,1,8);
        date1 = c.getTime();
        c.set(2018,3,8);
        date2 = c.getTime();
        manager.scheduleMaintenance(date1, date2);
        assertEquals(TimeUnit.MILLISECONDS.toDays((date2.getTime()-date1.getTime())),manager.calcDownTimeForFacility());
    }
        
    @Test
    public void testListFacilityProblems(){
        //"Maintenance Request #" + this.getRequestNum() + "\nStatus: " + this.getStatus() + "\nProblem: " + this.getProblem(); 
        String problem1 = "Bathroom is flooded";
        String problem2 = "Clock is crooked";
        manager.getFacility(name);
        assertEquals("No facility problems."
                ,manager.listFacilityProblems());
        manager.makeFacilityMaintRequest(problem1);
        manager.makeFacilityMaintRequest(problem2);
        assertEquals("Facility Problems:\n"+problem1+"\n"+problem2+"\n"
                ,manager.listFacilityProblems());
    }
}
