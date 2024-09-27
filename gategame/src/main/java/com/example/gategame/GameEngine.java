package com.example.gategame;

import com.example.gategame.map.MapFactory;
import com.example.gategame.settings.*;

/**
 * @author Hao Ye(u7981083)
 * Construct the game from config
 */
public class GameEngine {

    private static final GameEngine instance = new GameEngine();

    private GameEngine() {
    }

    public static GameEngine getInstance() {
        return instance;
    }

    private SettingsConfig settingsConfig;

    public SettingsConfig getSettingsConfig() {
        return settingsConfig;
    }

    public LevelConfig getCurrentLevelConfig() {
        return settingsConfig.getLevels().get(currentLevel);
    }

    public MonstersConfig getMonsterConfig() {
        return settingsConfig.getMonstersConfig();
    }

    public LootConfig getLootConfig() {
        return settingsConfig.getLootConfig();
    }

    public int currentLevel;

    public static void main(String[] args) {
        GameEngine.getInstance().loadEngine();
        // start play
        GameEngine.getInstance().setCurrentLevel(1);
    }

    /**
     * read engine configure file
     */
    public void loadEngine() {
        settingsConfig = GameConfigLoader.loadConfig();
    }

    /**
     * go to new level
     *
     * @param level
     */
    public void setCurrentLevel(int level) {
        this.currentLevel = level;
        MapFactory.createMap(GameConfigLoader.config.getLevels().get(level));
        // display map to play

    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void gotoNextLevel() {
        setCurrentLevel(++currentLevel);
    }
}
