package com.example.gategame.role;

import com.example.gategame.backpack.Inventory;
import com.example.gategame.items.Item;
import com.example.gategame.backpack.MonsterBackpack;
import com.example.gategame.items.general.potion.Potion;
import com.example.gategame.items.general.UsableItem;
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
        assertTrue(((UsableItem) item).getPower() >= 1);
        assertTrue(((UsableItem) item).getPower() < 10);

    }

}
