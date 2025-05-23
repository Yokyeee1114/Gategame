package com.example.gategame.settings;



import java.util.List;

/**
 * @author Hao Ye(u7981083)
 * Used to config initial player state
 */
public class PlayerConfig {

    private String name;
    private int power;
    private int health;
    private List<ItemConfig> initialItems;

    public PlayerConfig(String name, int power, int health, List<ItemConfig> initialItems) {
        this.name = name;
        this.power = power;
        this.health = health;
        this.initialItems = initialItems;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public List<ItemConfig> getInitialItems() {
        return initialItems;
    }

    public void setInitialItems(List<ItemConfig> initialItems) {
        this.initialItems = initialItems;
    }
}
