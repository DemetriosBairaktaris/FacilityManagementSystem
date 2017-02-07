package edu.luc.cs.comp473.project1.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.comp473.project1.model.facility.Building;

public class TestBuilding {

    private Building building;
    private String name = "Test Building";
    private String desc = "This building is for testing purposes.";
    
    @Before
    public void setUp() throws Exception {
        building = new Building(name, desc);
    }

    @Test
    public void testGetName() {
        assertEquals(building.getName(), name);
    }
    
    @Test
    public void testGetDescription() {
        assertEquals(building.getDescription(), desc);
    }
    
    

    @After
    public void tearDown() throws Exception {
    }
    
}
