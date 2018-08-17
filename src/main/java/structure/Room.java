package main.java.structure;

import java.util.HashMap;

public class Room {
  private String roomText;
  private HashMap<String, Room> exits;

  public Room (String enterText){
    this.roomText = enterText;
    this.exits = new HashMap<>();
  }
  public Room (String enterText, HashMap<String, Room> exits){
    this(enterText);
    this.exits = exits;
  }

  public void addExits(String exit, Room exitTo){
    this.exits.put(exit, exitTo);
  }

  public String enterRoom(){
    return roomText;
  }

  public Room exitTo(String room){
    return this.exits.get(room);
  }
}
