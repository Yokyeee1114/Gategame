package com.example.gategame.equipment;

import com.example.gategame.map.MapItem;
import com.example.gategame.role.Player;
import com.example.gategame.role.Role;
import com.example.gategame.utils.PrintUtils;

/**
 * @author Yeming Chen
 * Hp Potion is a kind of potion can restore player's hp
 */
public class HpPotion extends GeneralItem implements Potion, MapItem {

    public HpPotion(int id, String name, int power) {
        super(id, name, power);
    }


    @Override
    public void use(Role role) {
        Integer oldHealth = role.getHealth();
        role.restoreHealth(super.getPower());
        PrintUtils.print("%s used %s, restored %s HP".formatted(role.getName(),super.getName(), role.getHealth() - oldHealth));
    }

    @Override
    public String toString() {
        return super.getName() +
                ", power=" + super.getPower();
    }

    @Override
    public Character getSymbol() {
        return 'P';
    }

    @Override
    public void interact(Player player) {
        player.getBackpack().addItem(this);
    }
}
