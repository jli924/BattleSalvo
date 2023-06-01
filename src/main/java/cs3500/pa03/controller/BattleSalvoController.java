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
   * To handle the user's shots
   *
   * @param x the x coordinate of the shot
   * @param y the y coordinate of the shot
   *
   * @return a Boolean of whether the input was valid
   */
  public boolean handleShots(String x, String y) {
    int xCoord;
    int yCoord;
    try {
      xCoord = Integer.parseInt(x);
      yCoord = Integer.parseInt(y);
    } catch (NumberFormatException e) {
      view.invalidShot();
      return false;
    }
    if (xCoord > model.getBoard().getHeight() - 1 || yCoord > model.getBoard().getWidth() - 1) {
      view.invalidShot();
      return false;
    } else {
      model.handleShots(xCoord, yCoord);
      return true;
    }
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
      model.setShots();
      return true;
    }
  }

  /**
   * To run the OOD BattleSalvo game!
   */
  public void run() {
    Scanner sc = new Scanner(this.input);
    // welcome the user
    view.welcomeScreen();
    boolean validInput = false;
    while(!validInput) {
      validInput = checkBoardDimensions(sc.next(), sc.next());
    }
    validInput = false;
    view.askForFleetSize(fleetSize);
    while (!validInput) {
      validInput= checkFleetSize(sc.next(), sc.next(), sc.next(), sc.next());
    }
    validInput = false;
    view.showOpponentBoard(model.getAiBoard());
    view.showMyBoard(model.getUserBoard());
    view.requestShots(model.getNumOfShots());
    while (!validInput) {
      for (int i = 0; i < model.getNumOfShots(); i++) {
        validInput = handleShots(sc.next(), sc.next());
      }
    }
    validInput = false;
    // here, make a loop to let the players play until one lose!
    // AI shots aren't being taken correctly FYI
  }
}
