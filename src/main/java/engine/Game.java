package main.java.engine;

import main.java.structure.Room;

public class Game {

  private Room currentRoom;

  public void parseInstructions(String line) {
    if (line.equals("quit"))
      Main.stopGame();
  }
}
