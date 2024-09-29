package com.example.gategame.role.monster;

import com.example.gategame.backpack.Backpack;

/**
 * @author Hao Ye(u7981083)
 */
public class MinorMonster extends Monster {
    public MinorMonster(Integer power, Integer maxHealth, Backpack backpack) {
        super("MinorMonster", "", power, maxHealth, backpack);
    }

    @Override
    public Character getSymbol() {
        return 'M';
    }
}
