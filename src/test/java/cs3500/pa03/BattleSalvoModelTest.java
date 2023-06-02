package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.model.BattleSalvoModel;
import cs3500.pa03.model.Board;
import cs3500.pa03.model.ShipType;
import org.junit.jupiter.api.Test;

/**
 * Tests for the BattleSalvoModel
 */
public class BattleSalvoModelTest {
  Board board = new Board(6, 6);
  BattleSalvoModel model = new BattleSalvoModel(6, 6);

  /**
   * To test the getAiBoard method in BattleSalvoModel
   */
  @Test
  public void testGetAiBoard() {
    assertEquals(board.getBoard().length, model.getAiBoard().length);
  }

  /**
   * To test the getUserBoard method in BattleSalvoModel
   */
  @Test
  public void testGetUserBoard() {
    assertEquals(board.getBoard().length, model.getUserBoard().length);
  }

  /**
   * To test the setSpecifications method in BattleSalvoModel
   */
  @Test
  public void testSetSpecifications() {
    model.setSpecifications(1, 2, 3, 4);
    assertEquals(1, model.specifications.get(ShipType.CARRIER));
    assertEquals(2, model.specifications.get(ShipType.BATTLESHIP));
    assertEquals(3, model.specifications.get(ShipType.DESTROYER));
    assertEquals(4, model.specifications.get(ShipType.SUBMARINE));
  }

  /**
   * To test the setUpShips method in BattleSalvoModel
   */
  @Test
  public void testSetUpShips() {
    model.setUpShips(1, 2, 2, 1);
    assertEquals(6, model.getUserNumOfShots());
    assertEquals(6, model.getAiNumOfShots());
  }

  /**
   * To test the getUserNumOfShots method in BattleSalvoModel
   */
  @Test
  public void testGetUserNumOfShots() {
    model.setUpShips(1, 1, 2, 1);
    assertEquals(5, model.getUserNumOfShots());
  }

  /**
   * To test the getAiNumOfShots method in BattleSalvoModel
   */
  @Test
  public void testGetAiNumOfShots() {
    model.setUpShips(1, 1, 1, 1);
    assertEquals(4, model.getAiNumOfShots());
  }

  /**
   * To test the handleShots method in BattleSalvoModel
   */
  @Test
  public void testHandleShots() {
    model.handleShots(1, 0);
    assertEquals(1, model.user.takeShots().get(0).getX());
  }

  /**
   * To test the reportDamage method in BattleSalvoModel
   */
  @Test
  public void testReportDamage() {
    model.reportPlayerDamage();
    assertEquals(board.getBoard().length, model.user.opponentBoard.getBoard().length);
  }
}
