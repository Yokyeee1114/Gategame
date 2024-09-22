package com.example.gategame.equipment;

import com.example.gategame.control.Location;
import com.example.gategame.role.Role;
/**
 * @author Yeming Chen
 * Normal weapon is a kind of weapon can help player beat enermy.
 */
public class NormalWeapon extends GeneralItem implements Weapon{

    public NormalWeapon(int id, String name, int power) {
        super(id, name, power);
    }

    public NormalWeapon(String name, int power, int id, Location location) {
        super(id, name, power, location);
    }

    @Override
    public void use(Role role) {
        // equip to user
        //character.equip(this);
        System.out.println(super.getName() + "equipped");
    }


    @Override
    public Integer getDamage() {
        return super.getPower();
    }

    @Override
    public String toString() {
        return "NormalWeapon{" +
                "name='" + super.getName() + '\'' +
                ", power=" + super.getPower() +
                ", id=" + super.getId() +
                '}';
    }
}
