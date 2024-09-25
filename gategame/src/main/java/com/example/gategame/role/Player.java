package com.example.gategame.role;

import com.example.gategame.backpack.Backpack;
import com.example.gategame.backpack.Inventory;
import com.example.gategame.backpack.PlayerBackpack;
import com.example.gategame.equipment.Weapon;

/**
 * @author Hao Ye(u7981083)
 */
public class Player extends Role {

    Weapon weapon;
    PlayerBackpack backpack;

    public Player(String name, String description, Integer power, Integer maxHealth) {
        super(name, description, power, maxHealth);
        this.backpack = Inventory.getInventory().createBackpack();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Put current weapon back to backpack if exists.
     * @param weapon the weapon player wants to switch to
     */
    public void setWeapon(Weapon weapon) {
        if (weapon != null) {
            backpack.addItem(weapon);
        }
        this.weapon = weapon;
    }

    /**
     *
     * @return role's power + weapon's damage
     */
    @Override
    public Integer getDamage() {
        Integer damage = super.getDamage();
        if(weapon != null){
            damage += weapon.getDamage();
        }
        return damage;
    }

    public PlayerBackpack getBackpack() {
        return backpack;
    }
//    public Backpack getBackpack() {
//        return backpack;
//    }
}
