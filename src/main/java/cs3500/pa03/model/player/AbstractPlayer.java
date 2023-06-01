package cs3500.pa03.model.player;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.ShipType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * To represent a player
 */
abstract class AbstractPlayer implements Player {
  Board board;
  int numOfShots = 0;
  List<Ship> ships = new ArrayList<>();
  List<Coord> shotsTaken = new ArrayList<>();

  /**
   * To update the player's board
   *
   * @param height the height of the board
   * @param width the width of the board
   */
  public void updateBoards(int height, int width) {
    this.board = new Board(height, width);
  }

  /**
   * To get a player's board (the array, board)
   *
   * @return an array (the board)
   */
  public String[][] getBoard() {
    return board.getBoard();
  }

  /**
   * To set the number of shots a player has
   *
   * @param ships the list of ships that a player has
   */
  public void setNumOfShots(List<Ship> ships) {
    for (Ship ship : ships) {
      if (!ship.isSunk()) {
        this.numOfShots++;
      }
    }
  }

  /**
   * To get the number of shots a user has
   *
   * @return an int of the number of shots a player has
   */
  public int getNumOfShots() {
    return numOfShots;
  }

  /**
   * To get the list of ships a user has
   *
   * @return that list of ships
   */
  public List<Ship> getShips() {
    return this.ships;
  }

  /**
   * To set the list of ships for a player
   *
   * @param height the height of the board
   * @param width the width of the board
   * @param specifications the map of ships to how many the user selected
   */
  public void setShips(int height, int width, Map<ShipType, Integer> specifications) {
    this.ships = setup(height, width, specifications);
  }

  /**
   * Get the player's name.
   *
   * @return the player's name
   */
  @Override
  abstract public String name();

  /**
   * Given the specifications for a BattleSalvo board, return a list of ships with their locations
   * on the board.
   *
   * @param height         the height of the board, range: [6, 15] inclusive
   * @param width          the width of the board, range: [6, 15] inclusive
   * @param specifications a map of ship type to the number of occurrences each ship should
   *                       appear on the board
   * @return the placements of each ship on the board
   */
  @Override
  public List<Ship> setup(int height, int width, Map<ShipType, Integer> specifications) {
    return board.placeShip(specifications);
  }

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  @Override
  public List<Coord> takeShots() {
    return this.shotsTaken;
  }

  /**
   * Given the list of shots the opponent has fired on this player's board, report which
   * shots hit a ship on this player's board.
   *
   * @param opponentShotsOnBoard the opponent's shots on this player's board
   * @return a filtered list of the given shots that contain all locations of shots that hit a
   * ship on this board
   */
  @Override
  public List<Coord> reportDamage(List<Coord> opponentShotsOnBoard) {
    return board.updateDamage(opponentShotsOnBoard);
  }

  /**
   * Reports to this player what shots in their previous volley returned from takeShots()
   * successfully hit an opponent's ship.
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {

  }

  /**
   * Notifies the player that the game is over.
   * Win, lose, and draw should all be supported
   *
   * @param result if the player has won, lost, or forced a draw
   * @param reason the reason for the game ending
   */
  @Override
  public void endGame(GameResult result, String reason) {

  }
}
