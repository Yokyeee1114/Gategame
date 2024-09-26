package com.example.gategame.items.gate;

import com.example.gategame.map.MapItem;
import com.example.gategame.role.Player;

/**
 * @author Hao Ye(u7981083)
 * Used to open gate
 */
public class GateKey implements MapItem {

    @Override
    public Character getSymbol() {
        return 'K';
    }

    /**
     * Put the key in play's backpack
     *
     * @param player
     */
    @Override
    public void interact(Player player) {
        System.out.printf("%s got a key", player.getName());
        // @TODO put this key to player's backpack

    }
}
