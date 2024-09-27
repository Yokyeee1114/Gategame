package com.example.gategame.items.general.weapon;

import com.example.gategame.items.general.GeneralItem;
import com.example.gategame.map.MapItem;
import com.example.gategame.role.Player;
import com.example.gategame.role.Role;
/**
 * @author Yeming Chen
 * Normal weapon is a kind of weapon can help player beat enermy.
 */
public class NormalWeapon extends GeneralItem implements Weapon, MapItem {

    public NormalWeapon(int id, String name, int power) {
        super(id, name, power);
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
        return super.getName() +
                ", power=" + super.getPower();
    }

    @Override
    public Character getSymbol() {
        return 'W';
    }

    @Override
    public void interact(Player player) {
        player.getBackpack().addItem(this);
    }
}
