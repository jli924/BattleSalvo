package cs3500.pa03.model;

/**
 * Represents a coordinate
 */
public class Coord {
  int x;
  int y;
  boolean hit;

  /**
   * Constructor
   */
  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
    this.hit = false;
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

  /**
   * Changes a coordinate's hit boolean to true
   */
  public void hit() {
    hit = true;
  }

  /**
   * Returns whether a coordinate has been hit (meaning it
   * is a ship coord that has been hit)
   */
  public boolean hasBeenHit() {
    return hit;
  }

}
