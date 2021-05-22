import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {

    /*
    Tests that the adjective for a given room is able to be retrieved correctly.
     */
    @Test
    public void testGetAdj() throws Exception {
        String testAdj = "funny";
        Room test = new Room(testAdj, null, null, null, null);
        assertEquals(testAdj, test.getAdj());
    }

    /*
    Tests that the object for a given room is able to be retrieved correctly.
     */
    @Test
    public void testGetObj() throws Exception {
        String testObj = "Chair";
        Room test = new Room(null, testObj, null, null, null);
        assertEquals(testObj, test.getObj());
    }

    /*
    Tests that the north door is actually the correct north door
     */
    @Test
    public void testGetNorthDoor() throws Exception {
        String testDoor = "North Door";
        Room test = new Room(null, null, testDoor, null, null);
        assertEquals(testDoor, test.getNorthDoor());
    }

    /*
    Tests that the south door is actually the correct south door
     */
    @Test
    public void testGetSouthDoor() throws Exception {
        String testDoor = "South Door";
        Room test = new Room(null, null, null, testDoor, null);
        assertEquals(testDoor, test.getSouthDoor());
    }

    /*
    Tests if the item retrieved actually exists in a given room
     */
    @Test
    public void testGetItem() throws Exception {
        String testItem = "Item";
        Room test = new Room(null, null, null, null, testItem);
        assertEquals(testItem, test.getItem());
    }

    /*
    Tests that the toString method for the room class outputs the properly expected string
     */
    @Test
    public void testToString() throws Exception {
        String adj = "Refinanced";
        String obj = "Tight pizza";
        String nDoor = "Dead";
        String sDoor = "Smart";
        String item = "caffeinated coffee";

        String expected = "You see a Refinanced room.\n" +
                "It has a Tight pizza\n" +
                "A Dead door leads North.\n" +
                "A Smart door leads South.";

        Room test = new Room("Refinanced", "Tight pizza", "Dead", "Smart", "caffeinated coffee");

        assertEquals(expected, test.toString());

    }
}