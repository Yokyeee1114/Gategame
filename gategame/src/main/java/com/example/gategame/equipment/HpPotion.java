package com.example.gategame.equipment;

import com.example.gategame.role.Role;
import com.example.gategame.utils.PrintUtils;

/**
 * @author Yeming Chen
 * Hp Potion is a kind of potion can restore player's hp
 */
public class HpPotion implements Potion{
    private String name;
    private int power;
    private int id;

    public HpPotion(int id, String name, int power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void use(Role role) {
        Integer oldHealth = role.getHealth();
        role.restoreHealth(power);
        PrintUtils.print("%s used %s, restored %s HP".formatted(role.getName(),this.name, role.getHealth() - oldHealth));
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "HpPotion{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", id=" + id +
                '}';
    }
}
