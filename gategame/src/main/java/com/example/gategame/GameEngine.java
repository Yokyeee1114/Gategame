package com.example.gategame;

import com.example.gategame.map.MapFactory;
import com.example.gategame.settings.GameConfigLoader;
import com.example.gategame.settings.MonstersConfig;
import com.example.gategame.settings.SettingsConfig;

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

    public MonstersConfig getMonsterConfig() {
        return settingsConfig.getMonstersConfig();
    }

    public static Integer level;

    public static void main(String[] args) {
        GameEngine.getInstance().settingsConfig = GameConfigLoader.loadConfig();
        // start play
        setLevel(1);
    }

    public static void setLevel(Integer level) {
        GameEngine.level = level;
        MapFactory.createMap(GameConfigLoader.config.getLevels().get(level));
        // display map to play
    }
}
