package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.model.Coord;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Coord class
 */
public class CoordTest {
  Coord coord = new Coord(0, 1);

  /**
   * To test the getX method in Coord
   */
  @Test
  public void testGetX() {
    assertEquals(0, coord.getX());
  }

  /**
   * To test the getY method in Coord
   */
  @Test
  public void testGetY() {
    assertEquals(1, coord.getY());
  }

  /**
   * To test the hit method in Coord
   */
  @Test
  public void testHit() {
    coord.hit();
    assertTrue(coord.hasBeenHit());
  }

  /**
   * To test the hasBeenHit method in Coord
   */
  @Test
  public void testHasBeenHit() {
    coord.hit();
    assertTrue(coord.hasBeenHit());
  }
}
