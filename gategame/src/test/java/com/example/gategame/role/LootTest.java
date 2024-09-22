package com.example.gategame.role;

import com.example.gategame.backpack.Backpack;
import com.example.gategame.backpack.Inventory;
import com.example.gategame.backpack.Item;
import com.example.gategame.backpack.MonsterBackpack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LootTest {
    Inventory inventory = Inventory.getInventory();
    Backpack backpack = new MonsterBackpack();

    @Test
    public void testGenerate() {
        inventory.generateLoot(backpack, 0, 10);
        Item item = inventory.getAllItems().get(0);
        assertTrue(backpack.containsItem(item));
    }

}
