package cs3500.pa03.view;

import java.io.IOException;

/**
 * Handles what to show the user
 */
public class BattleSalvoView {
  public Appendable output;

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
      this.output.append("\nWelcome to OOD BattleSalvo!!\n"
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
      throw new RuntimeException();
    }
  }

  /**
   * Asks the user for a fleet size
   */
  public void askForFleetSize(int fleetSize) {
    try {
      this.output.append("------------------------------------------------------\n");
      this.output.append("Please enter your fleet in the order:\n");
      this.output.append("[Carrier, Battleship, Destroyer, Submarine].\n");
      this.output.append("Remember, your fleet may not exceed size " + fleetSize + ".\n");
      this.output.append("------------------------------------------------------\n");
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  /**
   * Notifies the user that their input was invalid and asks them to try again
   */
  public void invalidFleetSize(int fleetSize) {
    try {
      this.output.append("------------------------------------------------------\n");
      this.output.append("You entered invalid fleet sizes!\n");
      this.output.append("Please remember that your fleet cannot exceed size ");
      this.output.append(fleetSize + ".");
      this.output.append("\nIf you believe that you entered a valid fleet size,\n");
      this.output.append("please check and then try again! :)\n");
      this.output.append("------------------------------------------------------\n");
    } catch (IOException e) {
      throw new RuntimeException();
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
      throw new RuntimeException();
    }
  }

  /**
   * Shows the opponent's board
   */
  public void showOpponentBoard(String[][] board) {
    try {
      this.output.append("------------------------------------------------------\n");
      this.output.append("Opponent board:\n");
      for (int row = 0; row < board.length; row++) {
        this.output.append("     ");
        for (int col = 0; col < board[row].length; col++) {
          this.output.append(board[row][col] + " ");
        }
        this.output.append("\n");
      }
      this.output.append("\n");
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  /**
   * Shows the user's board
   */
  public void showMyBoard(String[][] board) {
    try {
      this.output.append("Your board:\n");
      for (int row = 0; row < board.length; row++) {
        this.output.append("     ");
        for (int col = 0; col < board[row].length; col++) {
          this.output.append(board[row][col] + " ");
        }
        this.output.append("\n");
      }
      this.output.append("------------------------------------------------------\n");
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  /**
   * Asks the user for shots
   */
  public void requestShots(int ships) {
    try {
      this.output.append("Please enter " + ships + " shots:\n");
      this.output.append("------------------------------------------------------\n");
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  /**
   * Notifies the user one of their shots was invalid
   */
  public void invalidShot() {
    try {
      this.output.append("------------------------------------------------------\n");
      this.output.append("You entered an invalid shot!\n");
      this.output.append("Remember, shots must be within board dimensions - 1!\n");
      this.output.append("Try again! :)\n");
      this.output.append("------------------------------------------------------\n");
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  /**
   * Notifies the user that the game is over
   */
  public void gameOver(String reason) {
    try {
      this.output.append("------------------------------------------------------\n");
      this.output.append("Game Over!\n");
      this.output.append(reason + "\n");
      this.output.append("------------------------------------------------------\n");
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }
}
