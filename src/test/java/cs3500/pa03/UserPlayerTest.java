package cs3500.pa03;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.player.UserPlayer;

/**
 * Tests for the UserPlayer class
 */
public class UserPlayerTest {
  Board board = new Board(6, 6);
  Board opponentBoard = new Board(6, 6);
  UserPlayer user = new UserPlayer(board, opponentBoard);

}
