package edu.luc.cs.comp473.project1.test;

import edu.luc.cs.comp473.project1.model.facility.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFacility {

    private Facility facility;
    private String name = "Water Tower Campus Apartment";
    private String desc = "LUC Campus located at Water Tower Place.";
    private String address = "911 Clark Street";

    @Before
    public void setUp() throws Exception {
        facility = new Apartment(name, desc, address);
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
        fail("not implemented");
        
        assertEquals(45,facility.requestAvailableCapacity());
    }
    
    @Test
    public void testAddFacilityDetail(){ //hold off for now
        fail("not implemented");
    }
    
    @Test 
    public void testIsInUseDuringInterval(){ //hold off for now
        fail("Not implemented");
    }
    
    @Test
    public void testAssignFacilityToUse(){
        fail("not implemented");
    }
    
    @Test
    public void testListActualUsage(){ //hold off for now
        fail("Not yet implemented");
    }
    
    @Test
    public void testCalcUsageRate(){//hold off
        fail("not implemented");
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
    
    @After
    public void tearDown() throws Exception {
        facility = null;
    }
}
