package edu.luc.cs.comp473.project1.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.comp473.project1.model.facility.Room;

public class TestRoom {

    private Room room;
    private int roomNum = 101;
    private int capacity = 40;
    
    @Before
    public void setUp() throws Exception {
        room = new Room(roomNum, capacity);
        
    }

    @Test
    public void testGetRoomNumber() {
        assertEquals(room.getRoomNumber(), roomNum);
    }
    
    @Test
    public void testGetCapacity() {
        assertEquals(room.getCapacity(), capacity);
    }
    
    @Test
    public void testAvailability() {
        room.setAvailability(true);
        assertTrue(room.isAvailable());
        room.setAvailability(false);
        assertFalse(room.isAvailable());
    }

    @After
    public void tearDown() throws Exception {
        room = null;
    }
    
}
