package cs3500.pa03.model.player;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.GameResult;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.ShipType;
import cs3500.pa03.view.BattleSalvoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * To represent a player
 */
abstract class AbstractPlayer implements Player {
  Board board;
  Board opponentBoard;
  List<Ship> ships = new ArrayList<>();
  List<Coord> shotsTaken = new ArrayList<>();
  BattleSalvoView view = new BattleSalvoView(System.out);
  public AbstractPlayer(Board board, Board opponentBoard) {
    this.board = board;
    this.opponentBoard = opponentBoard;
  }

  public int getShips() {
    return ships.size();
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
    if (this.ships.size() == 0) {
      this.ships = board.placeShip(specifications);
    }
    return this.ships;
  }

  /**
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  @Override
  public List<Coord> takeShots() {
    List<Coord> shots = new ArrayList<>();
    for (int i = 0; i < this.ships.size(); i++) {
      shots.add(board.takeRandomShot());
    }
    shotsTaken = shots;
    return shots;
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
    List<Coord> shotsHit = board.updateDamage(opponentShotsOnBoard);
    for (Coord coord : shotsHit) {
      for (Ship ship : ships) {
        for (Coord coord1 : ship.getCoords()) {
          if (coord1.getX() == coord.getX()
          && coord1.getY() == coord.getY()) {
            coord1.hit();
          }
        }
      }
    }
    for (int i = 0; i < ships.size(); i++) {
      if (ships.get(i).checkIfSunk()) {
        ships.remove(ships.get(i));
      }
    }
    return shotsHit;
  }

  /**
   * Reports to this player what shots in their previous volley returned from takeShots()
   * successfully hit an opponent's ship.
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  @Override
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {
    for (Coord coord : shotsTaken) {
      if (shotsThatHitOpponentShips.contains(coord)) {
        opponentBoard.replaceAtCoord(coord, "X");
      } else if (!opponentBoard.getBoard()[coord.getX()][coord.getY()].equals("X")) {
        opponentBoard.replaceAtCoord(coord, "0");
      }
    }
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
    view.gameOver(reason);
  }
}
