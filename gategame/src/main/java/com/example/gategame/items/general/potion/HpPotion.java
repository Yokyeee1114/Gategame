package com.example.gategame.items.general.potion;

import com.example.gategame.items.general.GeneralItem;
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


    /**
     * Use potion on the target
     *
     * @param role the target
     */
    @Override
    public void use(Player player) {
        Integer oldHealth = player.getHealth();
        player.restoreHealth(getHpPotionEffect(player));
        PrintUtils.print("%s used %s, restored %s HP".formatted(player.getName(),super.getName(), player.getHealth() - oldHealth));
    }

    /**
     * Calculate the effect of HpPotion
     *
     * @return how much health can be restored
     */
    public int getHpPotionEffect(Role role) {
        return getPower() * role.getMaxHealth() / 100;
    }


    @Override
    public String toString() {
        return super.getName() +
                ", power=" + super.getPower();
    }

    @Override
    public Character getSymbol() {
        return '+';
    }

    @Override
    public void interact(Player player) {
        player.getBackpack().addItem(this);
    }
}
