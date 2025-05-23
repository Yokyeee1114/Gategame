package com.example.gategame.role;

import com.example.gategame.backpack.Inventory;
import com.example.gategame.items.general.potion.Potion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Hao Ye(u7981083)
 */
class RoleTest {

    @Test
    @DisplayName("Change role's power")
    void setPower() {
        Player player = new Player("player", "", 10, 100);
        assertEquals(10, player.getPower());
        player.setPower(15);
        assertEquals(15, player.getPower());
    }

    @Test
    @DisplayName("Change role's health")
    void setHealth() {
        Role role = new Role("player", "", 10, 100);
        assertEquals(100, role.getHealth());
        role.setHealth(10);
        assertEquals(10, role.getHealth());
        role.setHealth(150);
        assertEquals(100, role.getHealth());
    }

    @Test
    @DisplayName("Change role's maxHealth")
    void setMaxHealth() {
        Role role = new Role("player", "", 10, 100);
        assertEquals(100, role.getMaxHealth());
        assertEquals(100, role.getHealth());
        role.setMaxHealth(150);
        assertEquals(150, role.getMaxHealth());
        assertEquals(150, role.getHealth());
    }

    @Test
    @DisplayName("Identify role's liveness")
    void isAlive() {
        Role role = new Role("player", "", 10, 100);
        assertTrue(role.isAlive());
        role.setHealth(0);
        assertFalse(role.isAlive());
        role.setHealth(-10);
        assertFalse(role.isAlive());
    }

    @Test
    @DisplayName("Attack opponent")
    void attack() {
        Role role = new Role("player", "", 20, 100);
        Role opponent = new Role("opponent", "", 10, 100);
        role.attack(opponent);
        assertEquals(80, opponent.getHealth());
        opponent.attack(role);
        assertEquals(90, role.getHealth());
    }


    @Test
    @DisplayName("Use HpPotion to restore health")
    void restoreHealth() {
        Player player = new Player("player", "", 20, 100);
        player.setHealth(50);
        Potion potion = Inventory.getInventory().createPotion("Small Curing Potion", 30);
        potion.use(player);
        assertEquals(80, player.getHealth());
        potion.use(player);
        assertEquals(100, player.getHealth());
    }
}