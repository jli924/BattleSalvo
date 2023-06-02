package cs3500.pa03.model;

import cs3500.pa03.model.player.AbstractPlayer;
import cs3500.pa03.model.player.AiPlayer;
import cs3500.pa03.model.player.Player;
import cs3500.pa03.model.player.UserPlayer;
import java.util.HashMap;

/**
 * BattleSalvo's model, manages functionality!
 */
public class BattleSalvoModel {
  AbstractPlayer ai;
  AbstractPlayer user;
  Board userBoard;
  Board opponentBoard;
  Board aiBoard;
  private HashMap<ShipType, Integer> specifications = new HashMap<>();
  public BattleSalvoModel(int height, int width) {
    userBoard = new Board(height, width);
    opponentBoard = new Board(height, width);
    aiBoard = new Board(height, width);
    user = new UserPlayer(userBoard, opponentBoard);
    ai = new AiPlayer(aiBoard, userBoard);
  }

  /**
   * Gets the AI's board
   *
   * @return an array representing the board
   */
  public String[][] getAiBoard() {
    return opponentBoard.getBoard();
  }

  /**
   * Gets the user's board
   *
   * @return an array representing the board
   */
   public String[][] getUserBoard() {
    return userBoard.getBoard();
  }

  /**
   * Gets the board (mostly used for height and width)
   */
   public Board getBoard() {
    return userBoard;
  }

  /**
   * Maps the ship type to the number of occurrences of each ship
   *
   * @param carrier the number of carriers the user chose
   * @param battleship the number of battleships the user chose
   * @param destroyer the number of destroyers the user chose
   * @param submarine the number of submarines the user chose
   */
  private void setSpecifications(int carrier, int battleship, int destroyer, int submarine) {
    specifications.put(ShipType.CARRIER, carrier);
    specifications.put(ShipType.BATTLESHIP, battleship);
    specifications.put(ShipType.DESTROYER, destroyer);
    specifications.put(ShipType.SUBMARINE, submarine);
  }

  /**
   * Set up both player's ships
   *
   * @param carrier the number of carriers the user chose
   * @param battleship the number of battleships the user chose
   * @param destroyer the number of destroyers the user chose
   * @param submarine the number of submarines the user chose
   */
  public void setUpShips(int carrier, int battleship, int destroyer, int submarine) {
    setSpecifications(carrier, battleship, destroyer, submarine);
    user.setup(userBoard.getHeight(), userBoard.getWidth(), specifications);
    ai.setup(aiBoard.getHeight(), aiBoard.getWidth(), specifications);
  }

  /**
   * Get the player's number of shots
   *
   * @return the number of shots
   */
  public int getUserNumOfShots() {
    //return user.getShips();
    return user.setup(userBoard.getHeight(), userBoard.getWidth(), specifications).size();
    //return user.takeShots().size();
  }

  /**
   * Get the AI's number of shots
   *
   * @return the number of shots
   */
  public int getAiNumOfShots() {
    return ai.setup(aiBoard.getHeight(), aiBoard.getWidth(), specifications).size();
  }

  /**
   * Handles the shots of the AI and the user player
   *
   * @param x the x coordinate of the user shot
   * @param y the y coordinate of the user shot
   */
  public void handleShots(int x, int y) {
    user.takeShots().add(new Coord(x, y));
  }

  /**
   * Reports both player's damage
   */
  public void reportPlayerDamage() {
    user.successfulHits(ai.reportDamage(user.takeShots()));
    ai.successfulHits(user.reportDamage(ai.takeShots()));
  }
}
