package com.example.gategame.map;

import com.example.gategame.role.Player;

/**
 * @author Hao Ye(u7981083)
 */
public interface MapItem {
    // the symbol to display on map
    Character getSymbol();

    // the action to perform when player meets item
    void interact(Player player);
}
