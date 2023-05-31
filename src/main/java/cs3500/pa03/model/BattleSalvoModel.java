package cs3500.pa03.model;

import cs3500.pa03.model.player.AiPlayer;
import cs3500.pa03.model.player.Player;
import cs3500.pa03.model.player.UserPlayer;
import java.util.HashMap;

public class BattleSalvoModel {
  UserPlayer user = new UserPlayer();
  AiPlayer ai = new AiPlayer();
  Board board;
  private HashMap<ShipType, Integer> specifications = new HashMap<>();

  public void setBoard(int height, int width) {
    board = new Board(height, width);
    user.updateBoards(height, width);
  }

  public String[][] getOpponentBoard() {
    return user.getOpponentBoard();
  }

  public String[][] getUserBoard() {
    return user.getBoard();
  }

  /**
   * Maps the ship type to the number of occurrences of each ship
   */
  public void setSpecifications(int carrier, int battleship, int destroyer, int submarine) {
    specifications.put(ShipType.CARRIER, carrier);
    specifications.put(ShipType.BATTLESHIP, battleship);
    specifications.put(ShipType.DESTROYER, destroyer);
    specifications.put(ShipType.SUBMARINE, submarine);
  }

  public void setUpShips(int carrier, int battleship, int destroyer, int submarine) {
    setSpecifications(carrier, battleship, destroyer, submarine);
    user.setup(board.getHeight(), board.getWidth(), specifications);
  }
}
