package main.java.engine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import main.java.Test.TestGame;
import main.java.structure.Exit;
import main.java.structure.Intractable;
import main.java.structure.Room;

public class Game {

  private Intractable currentRoom;
  private static HashSet<String> commands;

  public Game() {
    currentRoom = new Room("PLACEHOLDER ROOM", "IF YOU SEE THIS THE GAME DID NOT LOAD CORRECTLY");
    loadCommands();
  }

  public String changeCurrentRoom(Exit exit) {
    this.currentRoom = exit.exit();
    return currentRoom.interactText();
  }

  public void parseInstructions(String command, String line) {
    if (command.equals("quit") || command.equals("stop") || command.equals("exit")) {
      Main.stopGame();
    } else if (command.equals("test")) {
      currentRoom = TestGame.buildTestRooms();
    } else if (!commands.contains(command)) {
      System.out.println("Command '" + command + "' not recognized.");
    } else if (command.equals("go")) {
      currentRoom = currentRoom.exitTo(line).exit();
      System.out.println(currentRoom.interactText());
    } else {
      System.out.println(currentRoom.interact(command, line));
    }

  }

  private void loadCommands() {
    commands = new HashSet<>();
    File inFile = new File("./src/main/data/Commands");
    try {
      Scanner fileReader = new Scanner(inFile);
      fileReader.useDelimiter(",");
      while (fileReader.hasNext()) {
        commands.add(fileReader.next());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

}
