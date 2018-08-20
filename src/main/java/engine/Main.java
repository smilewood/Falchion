package main.java.engine;

import java.util.Scanner;
import main.java.structure.Intractable;

public class Main {
  private static boolean running = true;
  public static void main(String[] args) {
    Game game = new Game();
    Intractable.setBaseGame(game);

    Scanner input = new Scanner(System.in);
    String line;
    String instruction;
    System.out.println("Welcome");
    while (running) {
      System.out.print(" >> ");
      instruction = input.next();
      line = input.nextLine().trim();
      //System.out.println("Command: '" + instruction + "' \nTarget: '" + line + "'");
      game.parseInstructions(instruction.toLowerCase(), line.toLowerCase());
    }
  }

  /**
   * Ends the game loop after the current cycle.
   */
  public static void stopGame(){
    running = false;
    System.out.println("Goodbye.");
  }
}
