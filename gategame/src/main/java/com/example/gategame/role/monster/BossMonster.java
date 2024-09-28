package com.example.gategame.role.monster;

import com.example.gategame.backpack.Backpack;

/**
 * @author Hao Ye(u7981083)
 */
public class BossMonster extends Monster {
    public BossMonster(Integer power, Integer maxHealth, Backpack backpack) {
        super("BossMonster", "", power, maxHealth, backpack);
    }

    @Override
    public Character getSymbol() {
        return 'B';
    }
}
