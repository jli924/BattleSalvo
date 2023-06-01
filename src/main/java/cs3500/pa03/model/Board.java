package cs3500.pa03.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Represents a board
 */
public class Board {
  String[][] board;
  int height;
  int width;
  Random rand = new Random();

  /**
   * Constructor
   */
  public Board(int height, int width) {
    this.height = height;
    this.width = width;
    this.board = new String[height][width];
    initBoard();
  }

  /**
   * Constructor for testing
   */
  public Board(int height, int width, Random rand) {
    this.height = height;
    this.width = width;
    this.board = new String[height][width];
    this.rand = rand;
    initBoard();
  }

  /**
   * Initializes a board with "*" (no ships yet)
   */
  public void initBoard() {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = "*";
      }
    }
  }

  /**
   * Gets board
   *
   * @return an array representing the board
   */
  public String[][] getBoard() {
    return this.board;
  }

  /**
   * Gets the board's height
   *
   * @return the height as an int
   */
  public int getHeight() {
    return this.height;
  }

  /**
   * Gets the board's width
   *
   * @return the width as an int
   */
  public int getWidth() {
    return this.width;
  }

  /**
   * Randomly takes a shot
   *
   * @return the Coord of the shot
   */
  public Coord takeRandomShot() {
    int x = rand.nextInt(height);
    int y = rand.nextInt(width);
    return new Coord(x, y);
  }

  /**
   * Updates the board based on opponent's shots
   *
   * @return a list of coordinates of where hits landed on ships
   */
  public List<Coord> updateDamage(List<Coord> opponentShots) {
    List<Coord> hits = new ArrayList<>();
    for (Coord coord : opponentShots) {
      if (board[coord.getX()][coord.getY()].equals("C") ||
          board[coord.getX()][coord.getY()].equals("B") ||
          board[coord.getX()][coord.getY()].equals("D") ||
          board[coord.getX()][coord.getY()].equals("S")) {
        hits.add(coord);
        board[coord.getX()][coord.getY()] = "X";
      } else if (board[coord.getX()][coord.getY()].equals("*")){
        board[coord.getX()][coord.getY()] = "O";
      }
    }
    return hits;
  }

  /**
   * Tries to place a ship vertically
   *
   * @param x the x coordinate of a ship
   * @param y the y coordinate of a ship
   * @param shipType the ship type
   * @param ships the list of ships placed
   *
   * @return a Boolean of whether the ship was placed successfully
   */
  public boolean placeShipVertically(int x, int y, ShipType shipType, List<Ship> ships) {
    ArrayList<Coord> coords = new ArrayList<>();
    boolean foundSpace = false;
    boolean spaceForShip = true;
    if (x + shipType.size < this.height) {
      for (int i = 0; i < shipType.size; i++) {
        if (!board[x + i][y].equals("*")) {
          spaceForShip = false;
          break;
        }
      }
      if (spaceForShip) {
        for (int i = 0; i < shipType.size; i++) {
          board[x + i][y] = shipType.symbol;
          coords.add(new Coord(x + i, y));
        }
        ships.add(new Ship(shipType, coords, false));
        foundSpace = true;
      }
    } else if (x >= 5) {
      spaceForShip = true;
      for (int i = 0; i < shipType.size; i++) {
        if (!board[x - i][y].equals("*")) {
          spaceForShip = false;
          break;
        }
      }
      if (spaceForShip) {
        for (int i = 0; i < shipType.size; i++) {
          board[x - i][y] = shipType.symbol;
          coords.add(new Coord(x - i, y));
        }
        ships.add(new Ship(shipType, coords, false));
        foundSpace = true;
      }
    }
    return foundSpace;
  }

  /**
   * Tries to place a ship horizontally
   *
   * @param x the x coordinate of a ship
   * @param y the y coordinate of a ship
   * @param shipType the ship type
   * @param ships the list of ships placed
   *
   * @return a Boolean of whether the ship was placed successfully
   */
  public boolean placeShipHorizontally(int x, int y, ShipType shipType, List<Ship> ships) {
    ArrayList<Coord> coords = new ArrayList<>();
    boolean foundSpace = false;
    boolean spaceForShip = true;
    if (y + shipType.size < this.width) {
      for (int i = 0; i < shipType.size; i++) {
        if (!board[x][y + i].equals("*")) {
          spaceForShip = false;
          break;
        }
      }
      if (spaceForShip) {
        for (int i = 0; i < shipType.size; i++) {
          board[x][y + i] = shipType.symbol;
          coords.add(new Coord(x, y + i));
        }
        ships.add(new Ship(shipType, coords, false));
        foundSpace = true;
      }
    }
     else if (y >= 5) {
      spaceForShip = true;

      for (int i = 0; i < shipType.size; i++) {
        if (!board[x][y - i].equals("*")) {
          spaceForShip = false;
          break;
        }
      }
      if (spaceForShip) {
        for (int i = 0; i < shipType.size; i++) {
          board[x][y - i] = shipType.symbol;
          coords.add(new Coord(x, y - i));
        }
        ships.add(new Ship(shipType, coords, false));
        foundSpace = true;
      }
    }
    return foundSpace;
  }

  /**
   * Places ships on a board randomly
   *
   * @param specifications the map of the ships to how many a user selected
   *
   * @return a list of ships placed
   */
  public List<Ship> placeShip(Map<ShipType, Integer> specifications) {
    List<Ship> ships = new ArrayList<>();
    for (ShipType shipType : ShipType.values()) {
      int numOfShips = specifications.get(shipType);
      for (int i = 0; i < numOfShips; i++) {
        int x = rand.nextInt(height);
        int y = rand.nextInt(width);
        while (!board[x][y].equals("*")) {
          x = rand.nextInt(height);
          y = rand.nextInt(width);
        }
        if (rand.nextBoolean()) {
          while (!placeShipHorizontally(x, y, shipType, ships) &&
              !placeShipVertically(x, y, shipType, ships)) {
            x = rand.nextInt(height);
            y = rand.nextInt(width);
          }
        } else {
          while (!placeShipVertically(x, y, shipType, ships) &&
              !placeShipHorizontally(x, y, shipType, ships)) {
            x = rand.nextInt(height);
            y = rand.nextInt(width);
          }
        }
      }
    }
    return ships;
  }
}
