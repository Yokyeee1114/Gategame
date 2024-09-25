package com.example.gategame.settings;

/**
 * @author Hao Ye(u7981083)
 * Used to config initial player state
 */
public class PlayerConfig {

    private String name;
    private int power;
    private int health;

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
}
