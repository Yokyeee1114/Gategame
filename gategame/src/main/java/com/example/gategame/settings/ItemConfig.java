package com.example.gategame.settings;

import com.example.gategame.backpack.Inventory;
import com.example.gategame.backpack.Item;

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
    public Item createItem() {
        if ("potion".equals(type)) {
            return Inventory.getInventory().createPotion(name, power);
        } else if ("weapon".equals(type)) {
            return Inventory.getInventory().createWeapon(name, power);
        }
        throw new IllegalArgumentException("Unknown item type: " + type);
    }
}
