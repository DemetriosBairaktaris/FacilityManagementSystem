package edu.luc.cs.fms.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.luc.cs.fms.model.facility.BasicRoom;
import edu.luc.cs.fms.model.facility.Room;

/**
 * 
 * @author TeamDK
 *
 */
public class TestRoom {

    private Room room;
    private int roomNum = 101;
    private int capacity = 40;

    @Before
    public void setUp() throws Exception {
        room = new BasicRoom(roomNum, capacity);
    }

    @After
    public void tearDown() throws Exception {
        room = null;
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
    public void testGetAvailableCapacity() throws Exception {
        int initCapacity = room.getCapacity();
        assertTrue(initCapacity == (room.getAvailableCapacity()));
    }
}
