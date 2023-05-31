package cs3500.pa03.model;

/**
 * Represents a ship type
 */
public enum ShipType {
  CARRIER(6, "C"),
  BATTLESHIP(5, "B"),
  DESTROYER(4, "D"),
  SUBMARINE(3, "S");
  public final int size;
  public final String symbol;
  ShipType(int size, String symbol) {
    this.size = size;
    this.symbol = symbol;
  }
}
