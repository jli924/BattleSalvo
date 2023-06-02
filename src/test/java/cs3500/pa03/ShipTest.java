package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.model.Coord;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.ShipType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Ship class
 */
public class ShipTest {
  List<Coord> coords = new ArrayList<>(Arrays.asList(new Coord(0, 0)));
  List<Coord> coords2 = new ArrayList<>(Arrays.asList(new Coord(0, 0)));
  Ship ship = new Ship(ShipType.SUBMARINE, coords);
  Ship ship2 = new Ship(ShipType.SUBMARINE, coords2);

  /**
   * To test the method checkIfSunk in Ship
   */
  @Test
  public void testCheckIfSunk() {
    coords2.get(0).hit();
    assertFalse(ship.checkIfSunk());
    assertTrue(ship2.checkIfSunk());
  }

  /**
   * To test the method getCoords in Ship
   */
  @Test
  public void testGetCoords() {
    assertEquals(coords, ship.getCoords());
    assertEquals(coords2, ship2.getCoords());
  }
}
