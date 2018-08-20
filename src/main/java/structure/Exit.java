package main.java.structure;


import java.util.Objects;

public class Exit {
  private String name;
  private Intractable exitTo;

  public static Exit noExit(Intractable cur) {
    return new Exit("This is not an exit", cur);
  }

  public Exit (String exitName, Intractable target){
    this.name = exitName;
    this.exitTo = target;
  }

  public String getName() {
    return name;
  }

  public Intractable exit() {
    return exitTo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Exit exit = (Exit) o;
    return Objects.equals(name, exit.name);
  }


  public String toString() {
    return "Exit{" +
        "name='" + name + '\'' +
        ", exitTo=" + exitTo +
        '}';
  }
}
