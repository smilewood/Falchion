package main.java.engine;

import java.util.Scanner;

public class Main {
  private static boolean running = true;
  public static void main(String[] args) {
    Game game = new Game();
    Scanner input = new Scanner(System.in);
    String line;

    while (running) {
      line = input.nextLine();
      System.out.println(" >> " + line);
      if (line.equals("stop"))
        stopGame();
      game.parseInstructions(line);
    }
  }
  public static void stopGame(){
    running = false;
  }
}
