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
 * Represents the User player
 */
public class UserPlayer extends AbstractPlayer {
  Board board;
  Board opponentBoard;
  int numOfShots = 0;
  List<Ship> ships = new ArrayList<>();

  public void updateBoards(int height, int width) {
    board = new Board(height, width);
    opponentBoard = new Board(height, width);
  }

  public String[][] getBoard() {
    return board.getBoard();
  }

  public String[][] getOpponentBoard() {
    return opponentBoard.getBoard();
  }

  public void setNumOfShots(List<Ship> ships) {
    for (int i = 0; i < ships.size(); i++) {
      if (!ships.get(i).isSunk()) {
        this.numOfShots++;
      }
    }
  }

  public List<Ship> getShips() {
    return this.ships;
  }

  public void setShips(int height, int width, Map<ShipType, Integer> specifications) {
    this.ships = setup(height, width, specifications);
  }

  /**
   * Get the player's name.
   *
   * @return the player's name
   */
  @Override
  public String name() {
    return "Jamie Li";
  }

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
//    board.placeCarrier(specifications);
//    board.placeDestroyer(specifications);
//    board.placeSubmarine(specifications);
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
    return null;
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
    return null;
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
