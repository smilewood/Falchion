package main.java.structure;



public class Room extends Intractable{



  public Room (String name, String enterText){
    super(name, enterText);
  }

  @Override
  public Exit exitTo(String target) {
    Exit temp = super.exitTo(target);
    if (temp.equals(Exit.noExit(this))) {
      System.out.println("'" + target + "' is not an exit to " + this.name);
    }else {
      System.out.println("Exiting through " + temp.getName());
    }
    return temp;

  }


}
