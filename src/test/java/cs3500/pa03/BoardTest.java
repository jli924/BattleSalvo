package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.ShipType;
import cs3500.pa03.view.BattleSalvoView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.text.View;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Board class
 */
public class BoardTest {
  Random random = new Random(69);
  Board board = new Board(6, 7, random);
  Coord coord = new Coord(4, 5);
  List<Ship> ships = new ArrayList<>();

  /**
   * To test the initBoard method in Board
   */
  @Test
  public void testInitBoard() {
    board.initBoard();
    assertEquals(board.getBoard()[0][0], "*");
    assertEquals(board.getBoard()[5][5], "*");
  }

  /**
   * To test the getBoard method in Board
   */
  @Test
  public void testGetBoard() {
    board.initBoard();
    assertEquals(board.getBoard()[0][0], "*");
    assertEquals(board.getBoard()[5][6], "*");
  }

  /**
   * To test the getHeight method in Board
   */
  @Test
  public void testGetHeight() {
    assertEquals(6, board.getHeight());
  }

  /**
   * To test the getWidth method in Board
   */
  @Test
  public void testGetWidth() {
    assertEquals(7, board.getWidth());
  }

  /**
   * To test the takeRandomShot method in Board
   */
  @Test
  public void testTakeRandomShot() {
    assertEquals(coord.getX(), board.takeRandomShot().getX());
    assertEquals(coord.getY(), board.takeRandomShot().getY());
  }

  /**
   * To test the placeShipVertically method in Board
   */
  @Test
  public void testPlaceShipVertically() {
    assertEquals(true, board.placeShipVertically(0, 0, ShipType.CARRIER, ships));
    assertEquals(false, board.placeShipVertically(0, 0, ShipType.CARRIER, ships));
  }

  /**
   * To test the placeShipHorizontally method in Board
   */
  @Test
  public void testPlaceShipHorizontally() {
    assertEquals(true, board.placeShipHorizontally(4, 5, ShipType.SUBMARINE, ships));
    assertEquals(true, board.placeShipHorizontally(0, 0, ShipType.CARRIER, ships));
    assertEquals(false,
        board.placeShipHorizontally(4, 6, ShipType.DESTROYER, ships));
  }
}
