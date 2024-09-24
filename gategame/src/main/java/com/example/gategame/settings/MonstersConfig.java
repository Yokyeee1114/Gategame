package com.example.gategame.settings;

/**
 * @author Hao Ye(u7981083)
 */
public class MonstersConfig {

    MonsterConfig minor;
    MonsterConfig elite;
    MonsterConfig boss;


    public MonsterConfig getMinor() {
        return minor;
    }

    public void setMinor(MonsterConfig minor) {
        this.minor = minor;
    }

    public MonsterConfig getElite() {
        return elite;
    }

    public void setElite(MonsterConfig elite) {
        this.elite = elite;
    }

    public MonsterConfig getBoss() {
        return boss;
    }

    public void setBoss(MonsterConfig boss) {
        this.boss = boss;
    }
}
