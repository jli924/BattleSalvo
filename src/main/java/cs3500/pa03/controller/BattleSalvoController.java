package cs3500.pa03.controller;

import cs3500.pa03.view.BattleSalvoView;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BattleSalvoController {
  BattleSalvoView view;
  Readable input;
  public BattleSalvoController() {
    this.view = new BattleSalvoView(System.out);
    this.input = new InputStreamReader(System.in);
  }

  boolean checkBoardDimensions(int height, int width) {
    if (height < 6 || height > 15 || width < 6 || width > 15) {
      view.invalidDimensions();
      return false;
    } else {
      return true;
    }
  }

  public void run() {
    Scanner sc = new Scanner(this.input);
    view.welcomeScreen();
    boolean validInput = false;
    while(!validInput) {
      validInput = checkBoardDimensions(sc.nextInt(), sc.nextInt());
    }
  }
}
