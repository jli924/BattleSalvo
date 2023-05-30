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
   * Shows the user the welcome screen and asks for a valid board height and width
   */
  public void invalidDimensions() {
    try {
      this.output.append("You entered invalid dimensions!\nPlease remember that board" +
          " dimensions must be in the range of (6, 15) inclusive.\nTry again!\n");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
