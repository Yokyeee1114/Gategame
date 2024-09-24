package com.example.gategame.settings;

import java.io.Serializable;
import java.util.List;

/**
 * @author Hao Ye(u7981083)
 */
public class SettingsConfig implements Serializable {

    private List<LevelConfig> levels;

    public List<LevelConfig> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelConfig> levels) {
        this.levels = levels;
    }

}
