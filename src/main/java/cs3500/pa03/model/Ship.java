package cs3500.pa03.model;

import java.util.List;

/**
 * Represents a ship
 */
public class Ship {
  ShipType shipType;
  List<Coord> coords;
  boolean sunk;

  /**
   * Constructor
   */
  public Ship(ShipType shipType, List<Coord> coords, boolean sunk) {
    this.shipType = shipType;
    this.coords = coords;
    this.sunk = sunk;
  }

  /**
   * Returns whether a ship is sunk
   *
   * @return whether the ship is sunk
   */
  public boolean isSunk() {
    return sunk;
  }
}
