package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a ship
 */
public class Ship {
  ShipType shipType;
  List<Coord> coords = new ArrayList<>();
  boolean sunk;
  public Ship(ShipType shipType, List<Coord> coords, boolean sunk) {
    this.shipType = shipType;
    this.coords = coords;
    this.sunk = sunk;
  }
}
