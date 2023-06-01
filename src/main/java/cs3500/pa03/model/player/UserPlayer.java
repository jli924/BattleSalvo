package cs3500.pa03.model.player;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import java.util.List;

/**
 * Represents the User player
 */
public class UserPlayer extends AbstractPlayer {

  /**
   * Constructor
   */
//  public UserPlayer(Board opponentBoard) {
//    super();
//    this.opponentBoard = opponentBoard;
//  }

  public UserPlayer(Board board, Board opponentBoard) {
    super(board, opponentBoard);
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
   * Returns this player's shots on the opponent's board. The number of shots returned should
   * equal the number of ships on this player's board that have not sunk.
   *
   * @return the locations of shots on the opponent's board
   */
  @Override
  public List<Coord> takeShots() {
    return shotsTaken;
  }
}
