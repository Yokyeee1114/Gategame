package com.example.gategame.items.gate;

import com.example.gategame.GameEngine;
import com.example.gategame.map.MapItem;
import com.example.gategame.role.Player;

/**
 * @author Hao Ye(u7981083)
 */
public class Gate implements MapItem {

    private boolean isLocked;

    public Gate(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public Character getSymbol() {
        return 'D';
    }

    /**
     * if locked, use key to open, otherwise go to next level
     *
     * @param player
     */
    @Override
    public void interact(Player player) {
        if (isLocked) {
            // use key to open
        } else {
            System.out.println("Gate is open, are you ready to explore the next level?");
            GameEngine.getInstance().gotoNextLevel();
        }
    }
}
