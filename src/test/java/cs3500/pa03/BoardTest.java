package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Board class
 */
public class BoardTest {
  Random random = new Random(69);
  Board board = new Board(2, 2, random);
  Coord coord = new Coord(1, 1);

  /**
   * To test the initBoard method in Board
   */
  @Test
  public void testInitBoard() {
    board.initBoard();
    assertEquals(board.getBoard()[0][0], "*");
    assertEquals(board.getBoard()[1][1], "*");
  }

  /**
   * To test the getBoard method in Board
   */
  @Test
  public void testGetBoard() {
    board.initBoard();
    assertEquals(board.getBoard()[0][0], "*");
    assertEquals(board.getBoard()[1][1], "*");
  }

  /**
   * To test the getHeight method in Board
   */
  @Test
  public void testGetHeight() {
    assertEquals(board.getHeight(), 2);
  }

  /**
   * To test the getWidth method in Board
   */
  @Test
  public void testGetWidth() {
    assertEquals(board.getWidth(), 2);
  }
}
