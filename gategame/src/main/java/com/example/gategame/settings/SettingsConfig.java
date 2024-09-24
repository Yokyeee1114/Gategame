package com.example.gategame.settings;

import java.io.Serializable;
import java.util.List;

/**
 * @author Hao Ye(u7981083)
 */
public class SettingsConfig implements Serializable {

    private List<LevelConfig> levels;
    private MonstersConfig monstersConfig;
    private LootConfig lootConfig;


    public List<LevelConfig> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelConfig> levels) {
        this.levels = levels;
    }

    public MonstersConfig getMonstersConfig() {
        return monstersConfig;
    }

    public void setMonstersConfig(MonstersConfig monstersConfig) {
        this.monstersConfig = monstersConfig;
    }

    public LootConfig getLootConfig() {
        return lootConfig;
    }

    public void setLootConfig(LootConfig lootConfig) {
        this.lootConfig = lootConfig;
    }
}
