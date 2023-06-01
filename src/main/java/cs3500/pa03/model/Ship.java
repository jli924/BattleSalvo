package cs3500.pa03.model;

import java.util.List;

/**
 * Represents a ship
 */
public class Ship {
  // field public for testing
  public ShipType shipType;
  List<Coord> coords;

  /**
   * Constructor
   */
  public Ship(ShipType shipType, List<Coord> coords, boolean sunk) {
    this.shipType = shipType;
    this.coords = coords;
  }

  /**
   * Checks if a ship is sunk
   *
   * @return whether the ship is sunk
   */
  public boolean checkIfSunk() {
    for (Coord coord : coords) {
      if (!coord.hasBeenHit()) {
        return false;
      }
    }
    return true;
  }
}
