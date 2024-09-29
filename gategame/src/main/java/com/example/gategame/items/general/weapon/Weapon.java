package com.example.gategame.items.general.weapon;

import com.example.gategame.items.general.UsableItem;

/**
 * Weapon's properties.
 * @author Hao Ye(u7981083)
 */
public interface Weapon extends UsableItem {

    /**
     *
     * @return the damage a weapon could make
     */
    Integer getDamage();

}
