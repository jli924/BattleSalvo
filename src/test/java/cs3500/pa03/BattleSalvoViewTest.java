package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa03.view.BattleSalvoView;
import org.junit.jupiter.api.Test;

/**
 * Tests for the BattleSalvoView
 */
public class BattleSalvoViewTest {
  StringBuilder stringBuilder = new StringBuilder();
  BattleSalvoView view = new BattleSalvoView(stringBuilder);
  String welcomeScreen = "\nWelcome to OOD BattleSalvo!!\n"
      + "Please enter a valid board height and width below:\n"
      + "------------------------------------------------------\n";
  String invalidBoardDimensions = "------------------------------------------------------\n"
      + "You entered invalid dimensions!\nPlease remember that board"
      + " dimensions must be in the range of (6, 15) inclusive.\nTry again! :)\n"
      + "------------------------------------------------------\n";
  String askForFleetSize = "------------------------------------------------------\n"
      + "Please enter your fleet in the order:\n"
      + "[Carrier, Battleship, Destroyer, Submarine].\n"
      + "Remember, your fleet may not exceed size " + 4 + ".\n"
      + "------------------------------------------------------\n";
  String invalidFleetSize = "------------------------------------------------------\n"
      + "You entered invalid fleet sizes!\n"
      + "Please remember that your fleet cannot exceed size "
      + 5 + "."
      + "\nIf you believe that you entered a valid fleet size,\n"
      + "please check and then try again! :)\n"
      + "------------------------------------------------------\n";

  /**
   * To test the welcomeScreen method in BattleSalvoView
   */
  @Test
  public void testWelcomeScreen() {
    view.welcomeScreen();
    assertEquals(welcomeScreen, stringBuilder.toString());
  }

  /**
   * To test the invalidBoardDimensions method in BattleSalvoView
   */
  @Test
  public void testInvalidBoardDimensions() {
    view.invalidBoardDimensions();
    assertEquals(invalidBoardDimensions, stringBuilder.toString());
  }

  /**
   * To test the askForFleetSize method in BattleSalvoView
   */
  @Test
  public void testAskForFleetSize() {
    view.askForFleetSize(4);
    assertEquals(askForFleetSize, stringBuilder.toString());
  }

  /**
   * To test the invalidFleetSize method in BattleSalvoView
   */
  @Test
  public void testInvalidFleetSize() {
    view.invalidFleetSize(5);
    assertEquals(invalidFleetSize, stringBuilder.toString());
  }

//  /**
//   * To test the atLeastOneOfEachShip method in BattleSalvoView
//   */
//  @Test
//  public void testAtLeastOneOfEachShip() {
//    view.atLeastOneOfEachShip(6);
//    assertEquals(invalidFleetSize, stringBuilder.toString());
//  }
}
