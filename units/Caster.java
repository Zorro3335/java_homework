package java_homework.units;

import java.util.ArrayList;

public abstract class Caster extends java.lang.Character implements CharacterInterface {
  int mana;
  int maxMana;

  public Caster(Names name, int hp, int maxHp, int damage, int defense, int initiative, int speed, int mana, int maxMana, int x, int y) {
    super(name, hp, maxHp, damage, defense, initiative, speed, x, y);
    this.mana = mana;
    this.maxMana = maxMana;
  }

  private java.lang.Character findMostDamaged(ArrayList<java.lang.Character> team) {
    java.lang.Character mostDamaged = team.get(0);
    for (java.lang.Character character : team) {
      if (!character.state.equals(States.DEAD)
              && character.hp < character.maxHp
              && character.hp/character.maxHp < mostDamaged.hp/mostDamaged.maxHp) {
        mostDamaged = character;
      }
    }
    if (mostDamaged.hp == mostDamaged.maxHp) {
      return null;
    }
    return mostDamaged;
  }

  public void step(ArrayList<java.lang.Character> teamFoe, ArrayList<java.lang.Character> teamFriend) {
    if (state.equals(States.DEAD)) return;
    java.lang.Character damagedFriend = findMostDamaged(teamFriend);
    if (mana < maxMana) mana += 1;
    if (damagedFriend != null && mana >= damage) {
      damagedFriend.getHealing(damage);
      mana -= damage;
    }
  }

  @Override
  public String getInfo() {
    return super.getInfo() + String.format(" mana: %d/%d", this.mana, this.maxMana);
  }
}
