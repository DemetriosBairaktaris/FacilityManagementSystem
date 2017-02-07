package edu.luc.cs.comp473.project1.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.comp473.project1.dal.FacilityDAO;
import edu.luc.cs.comp473.project1.model.facility.Facility;

public class TestFacilityDAO {

    private FacilityDAO storage;
    private Facility facility = new Facility("test", "test");
    
    @Before
    public void setUp() throws Exception {
        storage = new FacilityDAO();
    }

    @Test
    public void testGetFacility() {
        storage.insertFacility(facility);
        assertEquals(facility, storage.getFacility("test"));
    }
    
    @Test
    public void testRemoveFacility() {
        storage.removeFacility(facility);
        assertNull(storage.getFacility("test"));
    }
    
    @After
    public void tearDown() throws Exception {
        storage = null;
    }
    
}
