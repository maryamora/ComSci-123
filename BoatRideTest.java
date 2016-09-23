//Code created by Hernandez, Amora

import junit.framework.TestCase;
import java.util.*;

public class BoatRideTest extends TestCase {
    
    public void testAddOne() {
      BoatRide ship = new BoatRide(5000.0,5.0);
      assertEquals("Added new ship with basefare", 5000.0, ship.getBaseFare());
      assertEquals("Discount",5.0, ship.getDistance());
    }
    
    public void testSorting() {
      BoatRide[] ships = {new BoatRide(200,3), new BoatRide(100,4)};
      Arrays.sort(ships);
      assertEquals("Added two BoatRides",100.0, ships[0].getBaseFare());
      assertEquals("Added two BoatRides",200.0, ships[1].getBaseFare());
    }
}
