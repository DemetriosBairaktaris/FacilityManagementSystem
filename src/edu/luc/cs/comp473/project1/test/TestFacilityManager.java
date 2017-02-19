package edu.luc.cs.comp473.project1.test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.comp473.project1.model.facility.ConcreteFacilityManager;
import edu.luc.cs.comp473.project1.model.facility.Facility;
import edu.luc.cs.comp473.project1.model.facility.FacilityManager;

public class TestFacilityManager {
    private FacilityManager manager ;
    private String name = "Cuneo";
    private String desc = "Building Containing classrooms" ;
    private String address = "23 west loyola ave";
    
    @Before
    public void setUp() throws Exception {
        manager = new ConcreteFacilityManager();
        manager.addNewFacility(name, desc, address);
        
    }

    @After
    public void tearDown() throws Exception {
        manager = null ; 
    }

    @Test
    public void testListFacilities() {
        assertEquals("Facilities:\nid:  "+name.hashCode()+"\n"+name+":  "+desc+"\n"+
                "Address:  "+address
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
        manager.addRoomToFacility(roomNumber, capacity, name);
        manager.getFacility(name);
        
        assertEquals("Rooms:\nRoom 1 - Capacity 20\n"
               ,manager.listRooms());
    }

}
