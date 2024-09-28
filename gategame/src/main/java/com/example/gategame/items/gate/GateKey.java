package com.example.gategame.items.gate;

import com.example.gategame.items.Item;
import com.example.gategame.map.MapItem;
import com.example.gategame.role.Player;

/**
 * @author Hao Ye(u7981083)
 * Used to open gate
 */
public class GateKey implements MapItem, Item {

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
        //System.out.printf("%s got a key", player.getName());
//        player.getBackpack().addItem(this); // addItem method has a print message already
    }

    @Override
    public String getName() {
        return "Key";
    }

    @Override
    public int getId() {
        return 999;
    }
}
