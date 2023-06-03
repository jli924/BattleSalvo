package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.Ship;
import cs3500.pa03.model.ShipType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Board class
 */
public class BoardTest {
  Random random = new Random(69);
  Board board = new Board(6, 7, random);
  Coord coord = new Coord(4, 5);
  List<Ship> ships = new ArrayList<>();
  List<Coord> hits = new ArrayList<>(
      Arrays.asList(new Coord(0, 0), new Coord(1, 1)));

  List<Coord> hitsThatHit = new ArrayList<>(List.of(new Coord(0, 0)));
  Map<ShipType, Integer> specifications = new HashMap<>();
  List<Ship> shipsPlaced =
      new ArrayList<>(List.of(new Ship(ShipType.SUBMARINE, hitsThatHit)));

  /**
   * To test the initBoard method in Board
   */
  @Test
  public void testInitBoard() {
    board.initBoard();
    assertEquals("*", board.getBoard()[0][0]);
    assertEquals("*", board.getBoard()[5][5]);
  }

  /**
   * To test the replaceAtCoord method in Board
   */
  @Test
  public void testReplaceAtCoord() {
    board.replaceAtCoord(coord, "hi!");
    assertEquals("hi!", board.getBoard()[4][5]);
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
   * To test the updateDamage method in Board
   */
  @Test
  public void testUpdateDamage() {
    board.placeShipVertically(0, 0, ShipType.CARRIER, ships);
    assertEquals(hitsThatHit.get(0).getX(), board.updateDamage(hits).get(0).getX());
  }

  /**
   * To test the placeShipVertically method in Board
   */
  @Test
  public void testPlaceShipVertically() {
    assertTrue(board.placeShipVertically(0, 0, ShipType.CARRIER, ships));
    assertFalse(board.placeShipVertically(0, 0, ShipType.CARRIER, ships));
    assertFalse(board.placeShipVertically(5, 0, ShipType.CARRIER, ships));
  }

  /**
   * To test the placeShipHorizontally method in Board
   */
  @Test
  public void testPlaceShipHorizontally() {
    assertTrue(board.placeShipHorizontally(4, 5, ShipType.SUBMARINE, ships));
    assertTrue(board.placeShipHorizontally(0, 0, ShipType.CARRIER, ships));
    assertFalse(board.placeShipHorizontally(4, 6, ShipType.DESTROYER, ships));
  }

  /**
   * To test the placeShip method in Board
   */
  @Test
  public void testPlaceShip() {
    specifications.put(ShipType.CARRIER, 0);
    specifications.put(ShipType.BATTLESHIP, 0);
    specifications.put(ShipType.DESTROYER, 0);
    specifications.put(ShipType.SUBMARINE, 1);
    assertEquals(shipsPlaced.get(0).shipType, board.placeShip(specifications).get(0).shipType);
  }
}
