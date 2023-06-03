package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.Board;
import cs3500.pa03.model.Coord;
import cs3500.pa03.model.ShipType;
import cs3500.pa03.model.player.AbstractPlayer;
import cs3500.pa03.model.player.AiPlayer;
import cs3500.pa03.model.player.UserPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for the AbstractPlayer class
 */
public class AbstractPlayerTest {
  Random rand = new Random(69);
  Random rand2 = new Random(420);
  Board board = new Board(6, 6, rand);
  Board board2 = new Board(6, 6, rand2);
  Map<ShipType, Integer> specifications = new HashMap<>();
  AbstractPlayer user = new UserPlayer(board, board);
  AbstractPlayer ai = new AiPlayer(board2, board2);
  List<Coord> coords = new ArrayList<>(
      Arrays.asList(new Coord(3, 3), new Coord(0, 0),
          new Coord(0, 2), new Coord(0, 3), new Coord(0, 4),
          new Coord(0, 5)));

  /**
   * To initialize the specifications
   */
  @BeforeEach
  public void initSpecifications() {
    specifications.put(ShipType.CARRIER, 1);
    specifications.put(ShipType.BATTLESHIP, 2);
    specifications.put(ShipType.DESTROYER, 1);
    specifications.put(ShipType.SUBMARINE, 1);
  }

  /**
   * To test the setup method in AbstractPlayer
   */
  @Test
  public void testSetup() {
    initSpecifications();
    assertEquals(5, user.setup(6, 6, specifications).size());
  }

  /**
   * To test the takeShots method in AbstractPlayer
   */
  @Test
  public void testTakeShots() {
    initSpecifications();
    ai.setup(6, 6, specifications);
    assertEquals(5, ai.takeShots().size());
  }

  /**
   * To test the reportDamage method in AbstractPlayer
   */
  @Test
  public void testReportDamage() {
    initSpecifications();
    user.setup(6, 6, specifications);
    ai.setup(6, 6, specifications);
    assertEquals(2, ai.reportDamage(coords).size());
    assertEquals(5, user.reportDamage(coords).size());
  }

  /**
   * To test the successfulHits method in AbstractPlayer
   */
  @Test
  public void testSuccessfulHits() {
    initSpecifications();
    user.setup(6, 6, specifications);
    ai.setup(6, 6, specifications);
    user.successfulHits(ai.reportDamage(coords));
    ai.successfulHits(user.reportDamage(coords));
    assertEquals("X", user.board.getBoard()[0][2]);
    assertEquals("X", ai.board.getBoard()[0][5]);
  }
}
