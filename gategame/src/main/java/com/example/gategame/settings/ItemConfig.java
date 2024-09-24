package com.example.gategame.settings;

import com.example.gategame.backpack.Inventory;

/**
 * @author Yeming
 */
public class ItemConfig {
    private String type; // "potion" or "weapon"
    private String name;
    private int power;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    /**
     * create Item and add to inventory
     */
    public void createItem() {
        if ("potion".equals(type)) {
            Inventory.getInventory().createPotion(name, power);
            return;
        } else if ("weapon".equals(type)) {
            Inventory.getInventory().createWeapon(name, power);
            return;
        }
        throw new IllegalArgumentException("Unknown item type: " + type);
    }
}
