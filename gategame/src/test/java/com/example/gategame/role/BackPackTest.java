package com.example.gategame.role;

import com.example.gategame.backpack.Inventory;
import com.example.gategame.backpack.Item;
import com.example.gategame.equipment.Potion;
import com.example.gategame.equipment.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Yeming Chen
 * test for backpack filter
 */
public class BackPackTest {

    Inventory inventory = Inventory.getInventory();
    Player player = new Player("player", "", 10, 10);
    public void initInventory(){
        // add some sample items
        inventory.createPotion("Small Healing Potion", 5);
        inventory.createWeapon("Big Sword", 10);
        inventory.createPotion("large Healing Potion", 10);
        inventory.createWeapon("small Sword", 5);
    }
    public void initPlayerBackPack() {
        initInventory();
        for (Item i : inventory.getAllItems()) {
            player.backpack.addItem(i);
        }
    }

    @Test
    void testGetPotion() {
        initPlayerBackPack();
        assertEquals(inventory.getAllItems().get(0), player.backpack.getPotions().get(0));
        assertEquals(inventory.getAllItems().get(2), player.backpack.getPotions().get(1));

    }

    @Test
    void testGetWeapon() {
        initPlayerBackPack();
        player.backpack.getWeapons();
        assertEquals(inventory.getAllItems().get(1), player.backpack.getWeapons().get(0));
    }

    @Test
    void  mixTest(){
        initPlayerBackPack();
        for (Item i : player.backpack.getPotions()) {
            assertInstanceOf(Potion.class, i);
            assertFalse(i instanceof Weapon);
        }
        for (Item i : player.backpack.getWeapons()) {
            assertInstanceOf(Weapon.class, i);
            assertFalse(i instanceof Potion);
        }
    }


}
