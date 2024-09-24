package com.example.gategame.items;

import com.example.gategame.map.MapItem;
import com.example.gategame.role.Player;
import com.example.gategame.utils.PrintUtils;

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

    @Override
    public void interact(Player player) {
        if (isLocked) {
            PrintUtils.print("You need to find a key");
        } else {
            PrintUtils.print("Go to next level");
        }
    }
}
