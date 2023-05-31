package cs3500.pa03.controller;

import cs3500.pa03.model.BattleSalvoModel;
import cs3500.pa03.view.BattleSalvoView;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * BattleSalvo's controller
 */
public class BattleSalvoController {
  BattleSalvoModel model;
  BattleSalvoView view;
  Readable input;
  int fleetSize;

  /**
   * Constructor
   */
  public BattleSalvoController() {
    this.model = new BattleSalvoModel();
    this.view = new BattleSalvoView(System.out);
    this.input = new InputStreamReader(System.in);
  }

  /**
   * Checks whether valid board dimensions were given
   *
   * @param height the height the user entered
   * @param width the width the user entered
   *
   * @return a boolean whether the input was valid
   */
  boolean checkBoardDimensions(String height, String width) {
    int boardHeight;
    int boardWidth;
    try {
      boardHeight = Integer.parseInt(height);
      boardWidth = Integer.parseInt(width);
    } catch (NumberFormatException e) {
      view.invalidBoardDimensions();
      return false;
    }
    if (boardHeight < 6 || boardHeight > 15 || boardWidth < 6 || boardWidth > 15) {
      view.invalidBoardDimensions();
      return false;
    } else {
      model.setBoard(boardHeight, boardWidth);
      fleetSize = Math.min(boardHeight, boardWidth);
      return true;
    }
  }

  /**
   * Checks whether a valid fleet size was given
   *
   * @param carrier the number of carriers
   * @param battleship the number of battleships
   * @param destroyer the number of destroyers
   * @param submarine the number of submarines
   *
   * @return a boolean whether the input was valid
   */
  boolean checkFleetSize(String carrier, String battleship, String destroyer, String submarine) {
    int numOfCarrier;
    int numOfBattleship;
    int numOfDestroyer;
    int numOfSubmarine;
    try {
      numOfCarrier = Integer.parseInt(carrier);
      numOfBattleship = Integer.parseInt(battleship);
      numOfDestroyer = Integer.parseInt(destroyer);
      numOfSubmarine = Integer.parseInt(submarine);
    } catch (NumberFormatException e) {
      view.invalidFleetSize(fleetSize);
      return false;
    }
    if (numOfCarrier + numOfBattleship + numOfDestroyer + numOfSubmarine > fleetSize) {
      view.invalidFleetSize(fleetSize);
      return false;
    } else if (numOfCarrier == 0 || numOfBattleship == 0
        || numOfDestroyer == 0 || numOfSubmarine == 0) {
      view.atLeastOneOfEachShip(fleetSize);
      return false;
    } else {
      model.setUpShips(numOfCarrier, numOfBattleship, numOfDestroyer, numOfSubmarine);
      return true;
    }
  }

  /**
   * To run the OOD BattleSalvo game!
   */
  public void run() {
    Scanner sc = new Scanner(this.input);
    view.welcomeScreen();
    boolean validBoardInput = false;
    while(!validBoardInput) {
      validBoardInput = checkBoardDimensions(sc.next(), sc.next());
    }
    view.askForFleetSize(fleetSize);
    boolean validFleetSize = false;
    while (!validFleetSize) {
      validFleetSize = checkFleetSize(sc.next(), sc.next(), sc.next(), sc.next());
    }
  }
}
