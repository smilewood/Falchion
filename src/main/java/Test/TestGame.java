package main.java.Test;

import main.java.structure.Room;

public class TestGame {

  public static Room buildTestRooms() {
    System.out.println("Building test rooms... ");
    Room base = new Room("room 1", "You enter room 1");
    Room neighbor = new Room("Room 2", "You enter room 2");
    base.addExit("north", neighbor);
    neighbor.addExit("south", base);
    System.out.println("Test rooms complete");
    return base;
  }
}
