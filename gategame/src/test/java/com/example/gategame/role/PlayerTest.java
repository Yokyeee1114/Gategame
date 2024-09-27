package com.example.gategame.role;

import com.example.gategame.GameEngine;
import com.example.gategame.backpack.Inventory;
import com.example.gategame.items.general.potion.Potion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author Hao Ye(u7981083)
 */
class PlayerTest {

    @BeforeAll
    static void beforeAll() {
        GameEngine.getInstance().loadEngine();
    }

    @Test
    @DisplayName("Should use potion")
    void attack() {
        Player player = new Player("Test", "", 10, 100);
        Potion hpPotion = Inventory.getInventory().createPotion("Test", 5);
        player.backpack.addItem(hpPotion);
        Monster monster = RoleFactory.createMonster(MonsterType.MINOR);
        monster.attack(player);
        assertEquals(95, player.getHealth());
        boolean attacked = player.attack(monster);
        assertFalse(attacked);
    }
}