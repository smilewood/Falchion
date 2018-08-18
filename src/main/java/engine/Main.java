package main.java.engine;

import java.util.Scanner;

public class Main {
  private static boolean running = true;
  public static void main(String[] args) {
    Game game = new Game();
    Scanner input = new Scanner(System.in);
    String line;
    String instruction;

    while (running) {
      System.out.print(" >> ");
      instruction = input.next();
      line = input.nextLine().trim();
      System.out.println("Command: '" + instruction + "' \nTarget: '" + line + "'");
      game.parseInstructions(instruction, line);
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
