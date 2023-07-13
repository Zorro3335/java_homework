package java_homework.units;

import java.util.ArrayList;

public class Farmer extends java.lang.Character {

  public Farmer(Names name, int x, int y) {
    super(name, 2, 2, 1, 1, 1, 1, x, y);
  }

  @Override
  public void step(ArrayList<java.lang.Character> team, ArrayList<java.lang.Character> team2){
    if (state.equals(States.DEAD)) return;
    state = States.READY;
  }
  }
