package tatics;

import java.util.ArrayList;

/**
 * Created by long on 2/5/2017.
 */

public class Unit {
    public int hp, attack, defense, resist,level, speed,move;
    public static int capicity=5;
    private String name;
    public int x;
    public int y;
    public Item weapon;
    public Item armor;
    private ArrayList<Item> inventory;
    public void interact(Unit unit)
    {

    }

    public void calculate()
    {

    }

    public void addItem(Item item)
    {
        if(inventory.size()>capicity) {
            inventory.add(item);
        }
    }

    public void removeItem(String s)
    {
        for(int i =0 ; i<inventory.size();i++)
        {
            if(inventory.get(i).getName().equals(s))
            {
                inventory.remove(i);
            }
        }
    }

    public void trade(Unit unit, String s)
    {

        for(int i =0 ; i<inventory.size();i++)
        {
            if(inventory.get(i).getName().equals(s))
            {
                unit.addItem(inventory.get(i));
                inventory.remove(i);
            }
        }
    }


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getResist() {
        return resist;
    }

    public void setResist(int resist) {
        this.resist = resist;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMove() {
        return move;
    }

    public void setMove(int move) {
        this.move = move;
    }

    public static int getCapicity() {
        return capicity;
    }

    public static void setCapicity(int capicity) {
        Unit.capicity = capicity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Item getArmor() {
        return armor;
    }

    public void setArmor(Item armor) {
        this.armor = armor;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
}
