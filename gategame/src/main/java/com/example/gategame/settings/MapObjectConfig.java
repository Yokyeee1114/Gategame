package com.example.gategame.settings;

/**
 * @author Hao Ye(u7981083)
 * Used to config map monster amount
 */
public class MapObjectConfig {

    private int minor;
    private int elite;
    private int boss;

    public MapObjectConfig(int minor, int elite, int boss) {
        this.minor = minor;
        this.elite = elite;
        this.boss = boss;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getElite() {
        return elite;
    }

    public void setElite(int elite) {
        this.elite = elite;
    }

    public int getBoss() {
        return boss;
    }

    public void setBoss(int boss) {
        this.boss = boss;
    }
}
