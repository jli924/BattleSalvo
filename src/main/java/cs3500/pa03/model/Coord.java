package cs3500.pa03.model;

/**
 * Represents a coordinate
 */
public class Coord {
  int x;
  int y;

  /**
   * Constructor
   */
  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets the x value of the coordinate
   */
  public int getX() {
    return x;
  }

  /**
   * Gets the y value of the coordinate
   */
  public int getY() {
    return y;
  }
}
