package main.java.structure;

import java.util.HashMap;
import java.util.HashSet;

/**
 * abstract class for all intractable things, including rooms, objects, and items
 */
public abstract class Intractable {

  protected String name;
  protected HashMap<String, String> commandInteractions;
  protected HashMap<String, Exit> exits;
  protected String interactText;

  public Intractable(String name, String interactionText) {
    this.name = name;
    this.interactText = interactionText;
    this.commandInteractions = new HashMap<>();
    this.exits = new HashMap<>();
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
    if (commandInteractions.keySet().contains(command)) {
      return commandInteractions.get(command);
    } else {
      return ("'" + command + "' does not work on " + this.name);
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
