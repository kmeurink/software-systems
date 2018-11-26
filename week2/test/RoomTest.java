package ss.week2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week2.hotel.Guest;
import ss.week2.hotel.Room;
import ss.week2.hotel.Safe;

public class RoomTest {
    private Guest guest;
    private Room room;
    private Safe hotelSafe;
    
    @Before
    public void setUp() {
        guest = new Guest("Jip");
        // DONE: initialise the variable room
        room = new Room( 101, hotelSafe);
    }

    @Test
    public void testSetUp() {
        assertEquals(101, room.getNumber());
    }

    @Test
    public void testSetGuest() {
        room.setGuest(guest);
        assertEquals(guest, room.getGuest());
    }
    @Test
    public void testGetSafe() {
    	assertEquals(hotelSafe, room.getSafe());
    	
    }
    
}
