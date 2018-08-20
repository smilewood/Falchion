package main.java.structure;

import java.util.HashMap;
import java.util.HashSet;
import main.java.engine.Game;

/**
 * abstract class for all intractable things, including rooms, objects, and items
 */
public abstract class Intractable {

  protected static Game baseGame; //Must be set for callbacks;
  protected String name;
  protected HashMap<String, String> commandInteractions, examineInteractions;
  protected HashMap<String, Exit> exits, subObjects;
  protected String interactText;

  public static void setBaseGame(Game game) {
    baseGame = game;
  }

  public Intractable(String name, String interactionText) {
    this.name = name;
    this.interactText = interactionText;
    this.commandInteractions = new HashMap<>();
    this.exits = new HashMap<>();
    this.subObjects = new HashMap<>();
    this.examineInteractions = new HashMap<>();
  }

  public String interactText() {
    return interactText;
  }

  public HashSet<String> exits() {
    return (HashSet<String>) exits.keySet();
  }

  public void addExit(Exit exitTo) {
    exits.put(exitTo.getName(), exitTo);
  }

  public void addExit(String exit, Intractable target) {
    this.addExit(new Exit(exit, target));
  }

  public String interact(String command, String target) {
    if (command.equals("search") && subObjects.keySet().contains(target)) {
      return baseGame.changeCurrentRoom(subObjects.get(target));
    }
    if (command.equals("examine")) {
      if (examineInteractions.keySet().contains(target)) {
        return examineInteractions.get(target);
      } else {
        return "You cannot examine " + target;
      }
    }
    if (commandInteractions.keySet().contains(command)) {
      return commandInteractions.get(command);
    } else {
      return ("'" + command + "' does not work on " + this.name);
    }
  }

  public void addCommandInteraction(String command, String result) {
    this.commandInteractions.put(command, result);
  }

  public void addExamineInteractions(String object, String result) {
    this.examineInteractions.put(object, result);
  }

  public void addSubObject(String object, Exit exit) {
    this.subObjects.put(object, exit);
  }

  public Exit explore(String subObject) {
    if (subObjects.keySet().contains(subObject)) {
      return subObjects.get(subObject);
    } else {
      return Exit.noExit(this);
    }
  }

  public Exit exitTo(String target) {
    if (exits.keySet().contains(target)) {
      return exits.get(target);
    } else {
      return Exit.noExit(this);
    }
  }

  public String getName() {
    return name;
  }
}
