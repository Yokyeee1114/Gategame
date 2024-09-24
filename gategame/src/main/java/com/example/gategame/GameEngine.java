package com.example.gategame;

import com.example.gategame.map.MapFactory;
import com.example.gategame.settings.GameConfigLoader;

/**
 * @author Hao Ye(u7981083)
 */
public class GameEngine {

    public static Integer level;

    public static void main(String[] args) {
        GameConfigLoader.loadConfig();
        // start play
        setLevel(1);
    }

    public static void setLevel(Integer level) {
        GameEngine.level = level;
        MapFactory.createMap(GameConfigLoader.config.getLevels().get(level));
        // display map to play
    }
}
