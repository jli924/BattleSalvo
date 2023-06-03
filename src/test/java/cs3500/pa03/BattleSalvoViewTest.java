package cs3500.pa03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import cs3500.pa03.model.Board;
import cs3500.pa03.view.BattleSalvoView;
import cs3500.pa03.view.BrokenAppendable;
import org.junit.jupiter.api.Test;

/**
 * Tests for the BattleSalvoView
 */
public class BattleSalvoViewTest {
  Board board = new Board(6, 6);
  StringBuilder stringBuilder = new StringBuilder();
  Appendable brokenAppendable = new BrokenAppendable();
  BattleSalvoView view = new BattleSalvoView(stringBuilder);
  BattleSalvoView brokenView = new BattleSalvoView(brokenAppendable);
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
  String atLeastOneOfEachShip = "------------------------------------------------------\n"
      + "You must have at least one of each ship!\nPlease remember that your fleet cannot"
      + " exceed size " + 6 + "."
      + "\nTry again! :)\n"
      + "------------------------------------------------------\n";
  String opponentBoard = "------------------------------------------------------\n"
      + "Opponent board:\n"
      + "     * * * * * * \n"
      + "     * * * * * * \n"
      + "     * * * * * * \n"
      + "     * * * * * * \n"
      + "     * * * * * * \n"
      + "     * * * * * * \n\n";
  String myBoard = "Your board:\n"
      + "     * * * * * * \n"
      + "     * * * * * * \n"
      + "     * * * * * * \n"
      + "     * * * * * * \n"
      + "     * * * * * * \n"
      + "     * * * * * * \n"
      + "------------------------------------------------------\n";
  String requestShots = "Please enter " + 5 + " shots:\n"
      + "------------------------------------------------------\n";
  String invalidShot = "------------------------------------------------------\n"
      + "You entered an invalid shot!\n"
      + "Remember, shots must be within board dimensions - 1!\n"
      + "Try again! :)\n"
      + "------------------------------------------------------\n";
  String gameOver = "------------------------------------------------------\n"
      + "Game Over!\n"
      + "testing testing!" + "\n"
      + "------------------------------------------------------\n";

  /**
   * To test the welcomeScreen method in BattleSalvoView
   */
  @Test
  public void testWelcomeScreen() {
    view.welcomeScreen();
    assertEquals(welcomeScreen, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.welcomeScreen());
  }

  /**
   * To test the invalidBoardDimensions method in BattleSalvoView
   */
  @Test
  public void testInvalidBoardDimensions() {
    view.invalidBoardDimensions();
    assertEquals(invalidBoardDimensions, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.invalidBoardDimensions());
  }

  /**
   * To test the askForFleetSize method in BattleSalvoView
   */
  @Test
  public void testAskForFleetSize() {
    view.askForFleetSize(4);
    assertEquals(askForFleetSize, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.askForFleetSize(6));
  }

  /**
   * To test the invalidFleetSize method in BattleSalvoView
   */
  @Test
  public void testInvalidFleetSize() {
    view.invalidFleetSize(5);
    assertEquals(invalidFleetSize, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.invalidFleetSize(5));
  }

  /**
   * To test the atLeastOneOfEachShip method in BattleSalvoView
   */
  @Test
  public void testAtLeastOneOfEachShip() {
    view.atLeastOneOfEachShip(6);
    assertEquals(atLeastOneOfEachShip, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.atLeastOneOfEachShip(6));
  }

  /**
   * To test the showOpponentBoard method in BattleSalvoView
   */
  @Test
  public void testShowOpponentBoard() {
    board.initBoard();
    view.showOpponentBoard(board.getBoard());
    assertEquals(opponentBoard, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.showOpponentBoard(board.getBoard()));
  }

  /**
   * To test the showMyBoard method in BattleSalvoView
   */
  @Test
  public void testShowMyBoard() {
    board.initBoard();
    view.showMyBoard(board.getBoard());
    assertEquals(myBoard, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.showMyBoard(board.getBoard()));
  }

  /**
   * To test the requestShots method in BattleSalvoView
   */
  @Test
  public void testRequestShots() {
    view.requestShots(5);
    assertEquals(requestShots, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.requestShots(5));
  }

  /**
   * To test the invalidShot method in BattleSalvoView
   */
  @Test
  public void testInvalidShot() {
    view.invalidShot();
    assertEquals(invalidShot, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.invalidShot());
  }

  /**
   * To test the gameOver method in BattleSalvoView
   */
  @Test
  public void testGameOver() {
    view.gameOver("testing testing!");
    assertEquals(gameOver, stringBuilder.toString());
    assertThrows(RuntimeException.class, () -> brokenView.gameOver("testing!"));
  }
}
