package cs3500.pa03.model;

/**
 * Represents a ship type
 */
public enum ShipType {
  CARRIER(6),
  BATTLESHIP(5),
  DESTROYER(4),
  SUBMARINE(3);
  public final int size;
  ShipType(int size) {
    this.size = size;
  }
}
