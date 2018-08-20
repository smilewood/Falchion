package main.java.Test;

import main.java.structure.Exit;
import main.java.structure.Room;
import main.java.structure.RoomFeature;

public class TestGame {

  public static Room buildTestRooms() {
    System.out.println("Building test rooms... ");
    Room base = new Room("room 1", "You enter room 1. There is a desk in the center and one door to the north");
    Room neighbor = new Room("room 2", "You enter room 2. it is completely empty other then the door to the south that you entered through");
    base.addExit("north", neighbor);
    neighbor.addExit("south", base);
    RoomFeature desk = new RoomFeature("desk", "the desk is a normal looking wooden desk. then only thing on it is a pen.", base);
    desk.addExamineInteractions("pen", "an ordinary ballpoint pen with no ink in it");
    base.addSubObject("desk", new Exit("Desk", desk));
    System.out.println("Test rooms complete");
    return base;
  }
}
