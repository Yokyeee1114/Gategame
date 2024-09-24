package com.example.gategame.items;

import com.example.gategame.map.MapItem;
import com.example.gategame.role.Player;
import com.example.gategame.utils.PrintUtils;

/**
 * @author Hao Ye(u7981083)
 * Used to open gate
 */
public class GateKey implements MapItem {

    @Override
    public Character getSymbol() {
        return 'K';
    }

    @Override
    public void interact(Player player) {
        PrintUtils.print("player get a key");
    }
}
