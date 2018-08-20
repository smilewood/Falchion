package main.java.structure;

public class RoomFeature extends Intractable {


  public RoomFeature(String name, String interactionText, Intractable base) {
    super(name, interactionText);
    this.exits.put("Back", new Exit("Back", base));
  }

  @Override
  public Exit exitTo(String target) {
    return this.exits.get("Back");
  }

  @Override
  public void addExit(String exit, Intractable target) {
    System.out.println("Objects cannot have exits: " + this.name);
  }
}
