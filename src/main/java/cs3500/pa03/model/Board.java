package cs3500.pa03.model;

import java.util.Map;
import java.util.Random;

public class Board {
  String[][] board;
  int height;
  int width;
  Random rand = new Random();

  public Board(int height, int width) {
    this.height = height;
    this.width = width;
    this.board = new String[height][width];
    initBoard();
  }

  public void initBoard() {
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        board[row][col] = "o";
      }
    }
  }

  public String[][] getBoard() {
    return this.board;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }

  public boolean placeShipVertically(int x, int y, ShipType shipType) {
    boolean foundSpace = false;
    boolean spaceForShip = true;
    if (x + shipType.size < this.height) {
      for (int i = 0; i < shipType.size; i++) {
        if (!board[x + i][y].equals("o")) {
          spaceForShip = false;
        }
      }
      if (spaceForShip) {
        for (int i = 0; i < shipType.size; i++) {
          board[x + i][y] = shipType.symbol;
        }
        foundSpace = true;
      }
    } else if (x - shipType.size > 0) {
      for (int i = 0; i < shipType.size; i++) {
        if (!board[x - i][y].equals("o")) {
          spaceForShip = false;
        }
      }
      if (spaceForShip) {
        for (int i = 0; i < shipType.size; i++) {
          board[x - i][y] = shipType.symbol;
        }
        foundSpace = true;
      }
    }
    return foundSpace;
  }

  public boolean placeShipHorizontally(int x, int y, ShipType shipType) {
    boolean foundSpace = false;
    boolean spaceForShip = true;
    if (y + shipType.size < this.width) {
      for (int i = 0; i < shipType.size; i++) {
        if (!board[x][y + i].equals("o")) {
          spaceForShip = false;
        }
      }
      if (spaceForShip) {
        for (int i = 0; i < shipType.size; i++) {
          board[x][y + i] = shipType.symbol;
        }
        foundSpace = true;
      }
    } else if (y - shipType.size > 0) {
      for (int i = 0; i < shipType.size; i++) {
        if (!board[x][y - i].equals("o")) {
          spaceForShip = false;
        }
      }
      if (spaceForShip) {
        for (int i = 0; i < shipType.size; i++) {
          board[x][y - i] = shipType.symbol;
        }
        foundSpace = true;
      }
    }
    return foundSpace;
  }

  public void placeCarrier(Map<ShipType, Integer> specifications) {
    int numOfCarriers = specifications.get(ShipType.CARRIER);
    for (int i = 0; i < numOfCarriers; i++) {
      int x = rand.nextInt(height);
      int y = rand.nextInt(width);
      while (!board[x][y].equals("o")) {
        x = rand.nextInt(height);
        y = rand.nextInt(width);
      }
      if (!placeShipVertically(x, y, ShipType.CARRIER)) {
        placeShipHorizontally(x, y, ShipType.CARRIER);
      }
    }
  }

  public void placeBattleship(Map<ShipType, Integer> specifications) {
    int numOfBattleships = specifications.get(ShipType.BATTLESHIP);
    for (int i = 0; i < numOfBattleships; i++) {
      int x = rand.nextInt(height);
      int y = rand.nextInt(width);
      while (!board[x][y].equals("o")) {
        x = rand.nextInt(height);
        y = rand.nextInt(width);
      }
      if (!placeShipVertically(x, y, ShipType.BATTLESHIP)) {
        placeShipHorizontally(x, y, ShipType.BATTLESHIP);
      }
    }
  }

  public void placeDestroyer(Map<ShipType, Integer> specifications) {
    int numOfDestroyers = specifications.get(ShipType.DESTROYER);
    for (int i = 0; i < numOfDestroyers; i++) {
      int x = rand.nextInt(height);
      int y = rand.nextInt(width);
      while (!board[x][y].equals("o")) {
        x = rand.nextInt(height);
        y = rand.nextInt(width);
      }
      if (!placeShipVertically(x, y, ShipType.DESTROYER)) {
        placeShipHorizontally(x, y, ShipType.DESTROYER);
      } // what if we can't place a ship horizontally?
    }
  }

  public void placeSubmarine(Map<ShipType, Integer> specifications) {
    int numOfSubmarines = specifications.get(ShipType.SUBMARINE);
    for (int i = 0; i < numOfSubmarines; i++) {
      int x = rand.nextInt(height);
      int y = rand.nextInt(width);
      while (!board[x][y].equals("o")) {
        x = rand.nextInt(height);
        y = rand.nextInt(width);
      }
      if (!placeShipVertically(x, y, ShipType.SUBMARINE)) {
        placeShipHorizontally(x, y, ShipType.SUBMARINE);
      }
    }
  }
}
