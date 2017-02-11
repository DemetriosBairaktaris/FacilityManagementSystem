package edu.luc.cs.comp473.project1.test;

import edu.luc.cs.comp473.project1.model.facility.*;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFacility {

    private Facility facility;
    private String name = "Water Tower Campus";
    private String desc = "LUC Campus located at Water Tower Place.";
    private String address = "911 Clark Street";

    @Before
    public void setUp() throws Exception {
        facility = new Building(name, desc, address);
        facility.addFacilityDetail(new Room(1,20));
        facility.addFacilityDetail(new Room(2,25));
        facility.addFacilityDetail(new Room(11,20));
        
        
    }
    
    @Test
    public void testGetName() {
        assertEquals("Water Tower Campus", facility.getName());
    }
    
    @Test
    public void testGetDescription() {
        assertEquals(desc, facility.getDescription());
    }
    
    @Test 
    public void testGetFacilityInformation(){
        
        assertEquals(name+ ":  "+ desc + "\n"+
                "Address:  "+ address + "\n"+
                "Available Capacity:  "+ facility.requestAvailableCapacity(),
                facility.getFacilityInformation()
                );
    }
    
    @Test
    public void testRequestAvailableCapacity(){
        assertEquals(65,facility.requestAvailableCapacity());
        facility.addFacilityDetail(new Room(5,5));
        assertEquals(70,facility.requestAvailableCapacity());
    }
    
    @Test
    public void testAddFacilityDetail(){ //hold off for now
        assertEquals(3,facility.getRooms().size());
        facility.addFacilityDetail(new Room(5,13));
        assertEquals(4,facility.getRooms().size());
    }
    
    @Test 
    public void testIsInUseDuringInterval(){ 
        Date currentDate = new Date();
        Date one,two,three ; 
        one = new Date(currentDate.getTime()+30000);
        two = new Date(currentDate.getTime()+40000);
        three = new Date(currentDate.getTime()+31000);
        assertFalse(facility.isInUseDuringInterval(one,two));
        facility.assignFacilityToUse(one, two);
        assertTrue(facility.isInUseDuringInterval(one,two));
        assertTrue(facility.isInUseDuringInterval(one, three));
    }
    
    @Test
    public void testAssignFacilityToUse(){
        Date currentDate = new Date();
        Date one = new Date (currentDate.getTime()+200000);
        Date two = new Date(currentDate.getTime()+300000);
        assertTrue(facility.assignFacilityToUse(one, two));
        assertFalse(facility.assignFacilityToUse(new Date(currentDate.getTime()-20000), two));
        assertFalse(facility.assignFacilityToUse(one, one)) ; 
    }
    
    @Test
    public void testListActualUsage(){ 
       
       Date currentDate = new Date();
       Date one = new Date(currentDate.getTime()+30000);
       Date two = new Date(currentDate.getTime()+40000);
       Date three = new Date (currentDate.getTime()+50000);
       Date four = new Date (currentDate.getTime()+60000);
       facility.assignFacilityToUse(one, two);
       facility.assignFacilityToUse(three,four);
       
       assertEquals(
               "Usage Dates:\n"+
               one.toString()+" - "+ two.toString()+ "\n"+
               three.toString()+ " - "+ four.toString()+ "\n"        
               ,facility.listActualUsage());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testCalcUsageRate(){
        //Simple Case: 1 Day : should be 1/365
        Date one,two,three ;
        one = new Date(2018,0,1);
        two = new Date(2018,0,2);
        facility.assignFacilityToUse(one, two);
        assertEquals((1.0/365),facility.calcUsageRate(),0.005);
        
        
       //Complex Case: OverLapping Intervals
        one = new Date(2018,2,30);
        two = new Date(2018,3,10);
        three = new Date(2018,1,20);
        facility.assignFacilityToUse(one, two);
        facility.assignFacilityToUse(three, one);
        facility.assignFacilityToUse(three, two); // total should be 2-20-2018 -- 4-10-2018
        assertEquals((70560.0/525600.0),facility.calcUsageRate(),0.005);
    }
    
    @Test
    public void testVacateFacility() throws Exception{
        int initialCapacity = facility.requestAvailableCapacity();
        facility.vacateFacility();
        assertEquals(initialCapacity,facility.requestAvailableCapacity()); 
        facility.getRooms().get(0).addInhabitant("Steve");
        int currentCapacity =facility.requestAvailableCapacity();
        assertTrue(initialCapacity > currentCapacity); 
        facility.vacateFacility();
        currentCapacity = facility.requestAvailableCapacity();
        assertEquals(currentCapacity,initialCapacity);
    }
    
    @Test 
    public void testListInspections(){
        Inspection one = facility.inspect();
        Inspection two = facility.inspect();
        one.setPassed(false);
        two.setPassed(true);
        
        assertEquals("Inspections:\n"+
                one.getDate() + ":  failed\n"+
                two.getDate() + ":  passed\n",
                facility.listInspections()
                );
    }
    
    @After
    public void tearDown() throws Exception {
        facility = null;
    }
}