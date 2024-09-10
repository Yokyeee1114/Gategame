package com.example.gategame.equipment;

import com.example.gategame.role.Role;
/**
 * @author Yeming Chen
 * Normal weapon is a kind of weapon can help player beat enermy.
 */
public class NormalWeapon implements Weapon{
    private String name;
    private int power;
    private int id;

    public NormalWeapon(int id, String name, int power) {
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
        // equip to user
        //character.equip(this);
        System.out.println(name + "equipped");
    }

    public int getPower() {
        // additional atk during fight
        return power;
    }
}
