package com.example.gategame.role.monster;

import com.example.gategame.backpack.Backpack;

/**
 * @author Hao Ye(u7981083)
 */
public class EliteMonster extends Monster {
    public EliteMonster(Integer power, Integer maxHealth, Backpack backpack) {
        super("EliteMonster", "", power, maxHealth, backpack);
    }

    @Override
    public Character getSymbol() {
        return 'E';
    }
}
