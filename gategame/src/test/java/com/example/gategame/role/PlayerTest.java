package com.example.gategame.role;

import com.example.gategame.backpack.Inventory;
import com.example.gategame.equipment.NormalWeapon;
import com.example.gategame.equipment.Weapon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Hao Ye(u7981083)
 */
class PlayerTest {

    @Test
    @DisplayName("Should change to new weapon")
    void setWeapon() {
        Player player = new Player("player", "", 10, 100);
        assertNull(player.getWeapon());
        Weapon weapon = Inventory.getInventory().createWeapon("Sword", 10);
        player.setWeapon(weapon);
        assertEquals(weapon, player.getWeapon());
    }

    @Test
    @DisplayName("Should add damage with weapon")
    void getDamage() {
        Player player = new Player("player", "", 10, 100);
        assertEquals(10, player.getDamage());
        Weapon weapon = Inventory.getInventory().createWeapon("Sword", 10);
        player.setWeapon(weapon);
        assertEquals(20, player.getDamage());
    }
}