package main.java.engine;

import java.util.HashMap;
import main.java.structure.Room;

public class Main {

  public Room currentRoom;
  public static void main(String[] args) {
    Main main = new Main();
    main.currentRoom = new Room("room 1");
    HashMap<String, Room> temp = new HashMap<>();
    temp.put("1", main.currentRoom);
    main.currentRoom.addExits("1", new Room("Room 2", temp));

    System.out.println(main.currentRoom.enterRoom());
    main.currentRoom = main.currentRoom.exitTo("1");
    System.out.println(main.currentRoom.enterRoom());
    main.currentRoom = main.currentRoom.exitTo("1");
    System.out.println(main.currentRoom.enterRoom());
  }
}
