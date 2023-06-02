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
  public Ship(ShipType shipType, List<Coord> coords) {
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

  public List<Coord> getCoords() {
    return coords;
  }

  public Ship getShipAt(Coord coord) {
    for (Coord c : coords) {
      if (c.x == coord.x && c.y == coord.y) {
        return this;
      }
    }
    throw new RuntimeException("I can't find that Coord!");
  }
}
