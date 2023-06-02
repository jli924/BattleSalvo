package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.player.AbstractPlayer;
import cs3500.pa03.model.player.UserPlayer;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Tests for the UserPlayer class
 */
public class UserPlayerTest {
  Board board = new Board(6, 6);
  Board opponentBoard = new Board(6, 6);
  List<Coord> shotsTaken = new ArrayList<>();
  AbstractPlayer user = new UserPlayer(board, opponentBoard);

  /**
   * To test the name method in UserPlayer
   */
  @Test
  public void testName() {
    assertEquals("Jamie Li", user.name());
  }

  /**
   * To test the takeShots method in UserPlayer
   */
  @Test
  public void testTakeShots() {
    assertEquals(shotsTaken, user.takeShots());
  }
}
