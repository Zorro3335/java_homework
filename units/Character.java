package java_homework.units;

import java_homework.map.Coordinates;

import java.util.ArrayList;

public abstract class Character implements CharacterInterface {
  protected Names name;
  protected int hp;
  protected int maxHp;
  protected int damage;
  protected int defense;
  protected int initiative;
  protected int speed;
  protected Coordinates position;
  protected States state;

  public Character(Names name, int hp, int maxHp, int damage, int defense, int initiative, int speed, int x, int y) {
    this.name = name;
    this.hp = hp;
    this.maxHp = maxHp;
    this.damage = damage;
    this.defense = defense;
    this.initiative = initiative;
    this.speed = speed;
    this.position = new Coordinates(x, y);
    this.state = States.READY;
  }


  public Coordinates getCoordinates() {
    return position;
  }

  protected Character findNearest(ArrayList<Character> team) {
    ArrayList<Character> notDeadCharacters = new ArrayList<>();
    for (Character character : team) {
      if (!character.state.equals(States.DEAD)) notDeadCharacters.add(character);
    }
    if (notDeadCharacters.size() == 0) return null;
    Character nearest = notDeadCharacters.get(0);
    for (Character character : notDeadCharacters) {
      if (position.getDistance(character.getCoordinates()) < position.getDistance(nearest.getCoordinates())) {
        nearest = character;
      }
    }
    return nearest;
  }

  protected void getDamage(int damagePoints) {
    hp -= damagePoints;
    if (hp <= 0) {
      hp = 0;
      state = States.DEAD;
    }
  }

  public boolean isDead() {
    return state.equals(States.DEAD);
  }

  protected void getHealing(int healPoints) {
    hp += healPoints;
    if (hp > maxHp) hp = maxHp;
  }

  public String getInfo() {
    return String.format("nm: %s, cl: %s, st: %s, hp: %d/%d, dmg: %d, def: %d, init: %d, sp: %d", this.name.name(), this.toString(), this.state.name(), this.hp, this.maxHp, this.damage, this.defense, this.initiative, this.speed);
  }

  public int getInitiative() {
    return this.initiative;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}