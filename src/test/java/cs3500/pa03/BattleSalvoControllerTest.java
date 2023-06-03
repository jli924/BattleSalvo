package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import cs3500.pa03.controller.BattleSalvoController;
import org.junit.jupiter.api.Test;

/**
 * Tests for the BattleSalvoController
 */
public class BattleSalvoControllerTest {
  BattleSalvoController controller = new BattleSalvoController();

  /**
   * To test the checkBoardDimensions method in BattleSalvoController
   */
  @Test
  public void testCheckBoardDimensions() {
    assertTrue(controller.checkBoardDimensions("6", "6"));
    assertFalse(controller.checkBoardDimensions("e", "6"));
    assertFalse(controller.checkBoardDimensions("5", "h"));
    assertFalse(controller.checkBoardDimensions("19", "6"));
    assertFalse(controller.checkBoardDimensions("8", "20"));
  }

  /**
   * To test the handleShots method in BattleSalvoController
   */
  @Test
  public void testHandleShots() {
    controller.checkBoardDimensions("6", "6");
    assertTrue(controller.handleShots("0", "0"));
    assertFalse(controller.handleShots("69", "69"));
    assertFalse(controller.handleShots("h", "69"));
    assertFalse(controller.handleShots("69", "e"));
  }

  /**
   * To test the checkFleetSize method in BattleSalvoController
   */
  @Test
  public void testCheckFleetSize() {
    controller.checkBoardDimensions("6", "6");
    assertTrue(controller.checkFleetSize("1", "2", "2", "1"));
    assertFalse(controller.checkFleetSize("2", "2", "2", "2"));
    assertFalse(controller.checkFleetSize("0", "2", "2", "2"));
    assertFalse(controller.checkFleetSize("c", "2", "2", "2"));
    assertFalse(controller.checkFleetSize("2", "b", "2", "2"));
    assertFalse(controller.checkFleetSize("1", "2", "d", "2"));
    assertFalse(controller.checkFleetSize("1", "2", "2", "s"));
  }
}