package cs3500.pa03.view;

import java.io.IOException;

/**
 * Handles what to show the user
 */
public class BattleSalvoView {
  Appendable output;

  /**
   * Constructor
   */
  public BattleSalvoView(Appendable output) {
    this.output = output;
  }

  /**
   * Shows the user the welcome screen and asks for a valid board height and width
   */
  public void welcomeScreen() {
    try {
      this.output.append("Welcome to OOD BattleSalvo!!\n"
          + "Please enter a valid board height and width below:\n"
          + "------------------------------------------------------\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Notifies the user that their input was invalid and asks them to try again
   */
  public void invalidBoardDimensions() {
    try {
      this.output.append("------------------------------------------------------\n"
          + "You entered invalid dimensions!\nPlease remember that board"
          + " dimensions must be in the range of (6, 15) inclusive.\nTry again! :)\n"
          + "------------------------------------------------------\n");
    } catch (IOException e) {
      System.out.println("Something broke...");
    }
  }

  /**
   * Asks the user for a fleet size
   */
  public void askForFleetSize(int fleetSize) {
    try {
      this.output.append("------------------------------------------------------\n"
          + "Please enter your fleet in the order:\n" +
          "[Carrier, Battleship, Destroyer, Submarine].\n" +
          "Remember, your fleet may not exceed size " + fleetSize + ".\n"
          + "------------------------------------------------------\n");
    } catch (IOException e) {
      System.out.println("Something broke...");
    }
  }

  /**
   * Notifies the user that their input was invalid and asks them to try again
   */
  public void invalidFleetSize(int fleetSize) {
    try {
      this.output.append("------------------------------------------------------\n"
          + "You entered invalid fleet sizes!\nPlease remember that your fleet cannot"
          + " exceed size " + fleetSize + "."
          + "\nTry again! :)\n"
          + "------------------------------------------------------\n");
    } catch (IOException e) {
      System.out.println("Something broke...");
    }
  }

  /**
   * Notifies the user that they need at least one of each ship
   */
  public void atLeastOneOfEachShip(int fleetSize) {
    try {
      this.output.append("------------------------------------------------------\n"
          + "You must have at least one of each ship!\nPlease remember that your fleet cannot"
          + " exceed size " + fleetSize + "."
          + "\nTry again! :)\n"
          + "------------------------------------------------------\n");
    } catch (IOException e) {
      System.out.println("Something broke...");
    }
  }
}
