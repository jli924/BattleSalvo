package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.player.AbstractPlayer;
import cs3500.pa03.model.player.AiPlayer;
import org.junit.jupiter.api.Test;

/**
 * Tests for the AiPlayer class
 */
public class AiPlayerTest {
  Board board = new Board(6, 6);
  Board opponentBoard = new Board(6, 6);
  AbstractPlayer ai = new AiPlayer(board, opponentBoard);

  /**
   * To test the name method in AiPlayer
   */
  @Test
  public void testName() {
    assertEquals("AI Player", ai.name());
  }
}
