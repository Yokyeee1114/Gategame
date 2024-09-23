package com.example.gategame.map;

import com.example.gategame.items.Gate;
import com.example.gategame.items.GateKey;
import com.example.gategame.settings.LevelConfig;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Hao Ye(u7981083)
 * Used to generate map
 */
public class MapFactory {

    /**
     * @param levelConfig current level
     * @return the new map
     */
    public static GameMap createMap(LevelConfig levelConfig) {
        // all interactive items on map
        List<MapItem> items = new ArrayList<>();
        // add gate
        Gate gate = new Gate(levelConfig.getGate().isLocked());
        items.add(gate);
        if (gate.isLocked()) {
            items.add(new GateKey());
        }
        // add monsters

        // add items

        return new GameMap(new String[]{}, items);
    }

}
