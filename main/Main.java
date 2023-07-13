package java_homework.main;

import java_homework.units.Character;
import units.*;
import java_homework.views.View;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class Main {
  public static ArrayList<Character> team1 = new ArrayList<>();
  public static ArrayList<Character> team2 = new ArrayList<>();
  public static ArrayList<Character> allTeam = new ArrayList<>();

  public static void main(String[] args) {
    fillList(team1, 1);
    fillList(team2, 10);
    allTeam.addAll(team1);
    allTeam.addAll(team2);
    allTeam.sort(Comparator.comparingInt(Character::getInitiative));
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < 10; i++) {
      View.view();
      for (Character c : allTeam) {
        if (team1.contains(c)) {
          c.step(team2, team1);
        } else {
          c.step(team1, team2);
        }
      }
     scanner.nextLine();
    }
  }


  public static void fillList(ArrayList<Character> list, int xPosition) {
    Names[] names = Names.values();
    for (int i = 1; i <= 10; i++) {
      int cnt = new Random().nextInt(7);
      Names name = names[new Random().nextInt(names.length)];
      switch (cnt) {
        case 0: {
          list.add(new Crossbowman(name, xPosition, i));
          break;
        }
        case 1: {
          list.add(new Farmer(name, xPosition, i));
          break;
        }
        case 2: {
          list.add(new Mage(name, xPosition, i));
          break;
        }
        case 3: {
          list.add(new Priest(name, xPosition, i));
          break;
        }
        case 4: {
          list.add(new Rogue(name, xPosition, i));
          break;
        }
        case 5: {
          list.add(new Archer(name, xPosition, i));
          break;
        }
        default: {
          list.add(new Spearman(name, xPosition, i));
          break;
        }
      }
    }
  }
}
