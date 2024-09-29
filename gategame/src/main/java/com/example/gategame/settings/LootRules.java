package com.example.gategame.settings;

public class LootRules {
    private LootConfig minion;
    private LootConfig elite;
    private LootConfig boss;

    public LootConfig getMinion() {
        return minion;
    }

    public void setMinion(LootConfig minion) {
        this.minion = minion;
    }

    public LootConfig getElite() {
        return elite;
    }

    public void setElite(LootConfig elite) {
        this.elite = elite;
    }

    public LootConfig getBoss() {
        return boss;
    }

    public void setBoss(LootConfig boss) {
        this.boss = boss;
    }

    public LootConfig getLootConfig(String type) {
        return switch (type) {
            case "minion" -> minion;
            case "elite" -> elite;
            case "boss" -> boss;
            default -> null;
        };
    }
}
