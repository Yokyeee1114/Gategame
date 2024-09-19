package com.example.gategame.equipment;

import com.example.gategame.backpack.Item;

/**
 * Weapon's properties.
 * @author Hao Ye(u7981083)
 */
public interface Weapon extends Item {

    /**
     *
     * @return the damage a weapon could make
     */
    Integer getDamage();

}
