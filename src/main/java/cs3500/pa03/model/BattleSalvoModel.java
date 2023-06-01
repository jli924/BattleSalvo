package cs3500.pa03.model;

import cs3500.pa03.model.player.AiPlayer;
import cs3500.pa03.model.player.UserPlayer;
import java.util.HashMap;

/**
 * BattleSalvo's model, manages functionality!
 */
public class BattleSalvoModel {
  AiPlayer ai = new AiPlayer();
  UserPlayer user = new UserPlayer(ai.getAiBoard());
  Board board;
  private HashMap<ShipType, Integer> specifications = new HashMap<>();

  /**
   * Sets the board height and width
   *
   * @param height of the board
   * @param width of the board
   */
  public void setBoard(int height, int width) {
    board = new Board(height, width);
    user.updateBoards(height, width);
    ai.updateBoards(height, width);
  }

  /**
   * Gets the AI's board
   *
   * @return an array representing the board
   */
  public String[][] getAiBoard() {
    return ai.getBoard();
  }

  /**
   * Gets the user's board
   *
   * @return an array representing the board
   */
   public String[][] getUserBoard() {
    return user.getBoard();
  }

  /**
   * Gets the board (mostly used for height and width)
   */
   public Board getBoard() {
    return board;
  }

  /**
   * Maps the ship type to the number of occurrences of each ship
   *
   * @param carrier the number of carriers the user chose
   * @param battleship the number of battleships the user chose
   * @param destroyer the number of destroyers the user chose
   * @param submarine the number of submarines the user chose
   */
  public void setSpecifications(int carrier, int battleship, int destroyer, int submarine) {
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
    user.setShips(board.getHeight(), board.getWidth(), specifications);
    ai.setShips(board.getHeight(), board.getWidth(), specifications);
  }

  /**
   * Sets the number of shots for both players
   */
  public void setShots() {
    user.setNumOfShots(user.getShips());
    ai.setNumOfShots(ai.getShips());
  }

  /**
   * Get the player's number of shots
   *
   * @return the number of shots
   */
  public int getNumOfShots() {
    return user.getNumOfShots();
  }

  /**
   * Handles the shots of the AI and the user player
   *
   * @param x the x coordinate of the user shot
   * @param y the y coordinate of the user shot
   */
  public void handleShots(int x, int y) {
    user.takeShots().add(new Coord(x, y));
    user.reportDamage(ai.takeShots());
    ai.reportDamage(user.takeShots());
  }
}
