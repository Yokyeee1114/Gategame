package com.example.gategame.role;

import com.example.gategame.backpack.Backpack;
import com.example.gategame.backpack.Inventory;
import com.example.gategame.backpack.Item;
import com.example.gategame.backpack.MonsterBackpack;
import com.example.gategame.equipment.Potion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LootTest {
    Inventory inventory = Inventory.getInventory();
    MonsterBackpack backpack = new MonsterBackpack();

    @Test
    public void testGenerate() {
        inventory.generateLoot(backpack, "P", 1, 10);
        Item item = backpack.getItems().get(0);
        assertNotNull(item);
        assertTrue(backpack.containsItem(item));
        assertInstanceOf(Potion.class, item);
        assertTrue(item.getPower() >= 1);
        assertTrue(item.getPower() < 10);

    }

}
