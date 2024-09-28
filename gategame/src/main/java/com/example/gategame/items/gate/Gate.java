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
            if (!player.getBackpack().getItems(GateKey.class).isEmpty()) {
                GateKey key = player.getBackpack().getItems(GateKey.class).get(0);
                // use key
                player.getBackpack().removeItem(key.getId());
                this.isLocked = false;
                GameEngine.getInstance().gotoNextLevel();
            }
        } else {
            System.out.println("Gate is open, are you ready to explore the next level?");
            GameEngine.getInstance().gotoNextLevel();
        }
    }
    public void open(){
        isLocked = false;
    }
}
