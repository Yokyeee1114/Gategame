package com.example.gategame.role;

import com.example.gategame.backpack.Inventory;
import com.example.gategame.backpack.PlayerBackpack;
import com.example.gategame.equipment.HpPotion;
import com.example.gategame.equipment.Weapon;

import java.util.List;

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

//    public Backpack getBackpack() {
//        return backpack;
//    }

    /**
     * Play's battle strategy: use potion when damaged
     *
     * @param opponent
     */
    @Override
    public boolean attack(Role opponent) {
        if (usePotion()) {
            // use potion occupies the chance to attack
            return false;
        }
        return super.attack(opponent);
    }

    /**
     * if the hurt is greater than the potion can cure, use the potion
     *
     * @return if potion is used
     */
    private boolean usePotion() {
        int hurt = getMaxHealth() - getHealth();
        if (hurt == 0) {
            return false;
        }
        boolean usePotion = false;
        List<HpPotion> hpPotions = backpack.getItems(HpPotion.class);
        for (HpPotion hpPotion : hpPotions) {
            int effect = hpPotion.getHpPotionEffect(this);
            if (effect <= hurt) { // decide to use potion
                backpack.useItem(hpPotion, this);
                usePotion = true;
                break;
            }
        }
        return usePotion;
    }

    @Override
    public String toString() {
        return String.format("%s: Power(%d), Health(%d), MaxHealth(%d), Weapon(%s)", super.getName(), getPower(), getHealth(), getMaxHealth(), getWeapon());
    }
}
