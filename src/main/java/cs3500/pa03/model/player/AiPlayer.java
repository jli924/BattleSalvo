package cs3500.pa03.model.player;

import cs3500.pa03.model.Board;

/**
 * Represents the AI player
 */
public class AiPlayer extends AbstractPlayer {
  public AiPlayer(Board board, Board opponentBoard) {
    super(board, opponentBoard);
  }

//  /**
//   * Get the AI's board
//   *
//   * @return the board
//   */
//  public Board getAiBoard() {
//    return board;
//  }

  /**
   * Get the player's name.
   *
   * @return the player's name
   */
  @Override
  public String name() {
    return "AI Player";
  }
}
