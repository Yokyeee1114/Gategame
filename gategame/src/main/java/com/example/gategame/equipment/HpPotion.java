package com.example.gategame.equipment;

import com.example.gategame.role.Role;
import com.example.gategame.utils.PrintUtils;

/**
 * @author Yeming Chen
 * Hp Potion is a kind of potion can restore player's hp
 */
public class HpPotion extends GeneralItem implements Potion{

    public HpPotion(int id, String name, int power) {
        super(id, name, power);
    }


    /**
     * Use potion on the target
     *
     * @param role the target
     */
    @Override
    public void use(Role role) {
        Integer oldHealth = role.getHealth();
        role.restoreHealth(getHpPotionEffect(role));
        PrintUtils.print("%s used %s, restored %s HP".formatted(role.getName(),super.getName(), role.getHealth() - oldHealth));
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
        return "HpPotion{" +
                "name='" + super.getName() + '\'' +
                ", power=" + super.getPower() +
                ", id=" + super.getId() +
                '}';
    }
}
