package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.ShipType;
import org.junit.jupiter.api.Test;

/**
 * Tests for the enum ShipType
 */
public class ShipTypeTest {
  ShipType carrier = ShipType.CARRIER;
  ShipType battleship = ShipType.BATTLESHIP;
  ShipType destroyer = ShipType.DESTROYER;
  ShipType submarine = ShipType.SUBMARINE;

  /**
   * To test carrier in ShipType
   */
  @Test
  public void testCarrier() {
    assertEquals(6, carrier.size);
    assertEquals("C", carrier.symbol);
  }

  /**
   * To test battleship in ShipType
   */
  @Test
  public void testBattleship() {
    assertEquals(5, battleship.size);
    assertEquals("B", battleship.symbol);
  }

  /**
   * To test destroyer in ShipType
   */
  @Test
  public void testDestroyer() {
    assertEquals(4, destroyer.size);
    assertEquals("D", destroyer.symbol);
  }

  /**
   * To test submarine in ShipType
   */
  @Test
  public void testSubmarine() {
    assertEquals(3, submarine.size);
    assertEquals("S", submarine.symbol);
  }
}
