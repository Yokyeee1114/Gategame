package com.example.gategame.backpack;

import com.example.gategame.GameEngine;
import com.example.gategame.items.general.potion.HpPotion;
import com.example.gategame.items.general.weapon.NormalWeapon;
import com.example.gategame.items.general.potion.Potion;
import com.example.gategame.items.general.weapon.Weapon;
import com.example.gategame.items.Item;
import com.example.gategame.settings.LootConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Yeming Chen
 * Inventory system used to manage all items in the game
 */
public class Inventory {
    private List<Item> allItems;  // List to hold items
    private static Inventory inventory = null;
    private static int nextId = 0; // generate id of next item

    public Inventory() {
        this.allItems = new ArrayList<>();
    }

    public static Inventory getInventory() {
        if (inventory == null) {
            inventory = new Inventory();
        }
        return inventory;
    }

    // Method to add an item
    public void addItem(Item item) {
        if (item != null) {
            allItems.add(item);
            System.out.println("item " + item.getName() + " added");
        }
    }

    /**
     * create weapon based on given power
     *
     * @param name name of weapon
     * @param power the atk of weapon
     * @return a weapon
     */
    public Weapon createWeapon(String name, int power) {
        // create and add to the inventory
        int id = nextId++;
        Weapon newItem = new NormalWeapon(id, name, power);
        allItems.add(newItem);
        return newItem;
    }

    /**
     * create hp potion based on given power
     *
     * @param name name of potion
     * @param power amount of hp potion can restore
     * @return a hp potion created
     */
    public HpPotion createPotion(String name, int power) {
        // create and add to the inventory
        int id = nextId++;
        HpPotion newItem = new HpPotion(id, name, power);
        allItems.add(newItem);
        return newItem;
    }

    /**
     * Create a hp potion that can full restore player's hp
     *
     * @return an ultimate hp potion with power 100
     */
    public HpPotion createUltimatePotion() {
        // create and add to the inventory
        int id = nextId++;
        HpPotion newItem = new HpPotion(id, "Ultimate Potion", 100);
        allItems.add(newItem);
        return newItem;
    }

    /**
     * Create a hp potion that can restore player's hp by 30%
     *
     * @return a hp potion with power 30
     */
    public HpPotion createMediumPotion() {
        // create and add to the inventory
        int id = nextId++;
        HpPotion newItem = new HpPotion(id, "Medium Potion", 30);
        allItems.add(newItem);
        return newItem;
    }

    public PlayerBackpack createBackpack() {
        return new PlayerBackpack();
    }
    /**
     * create items to put the monster's backpack
     *
     * @param types  control what items to create
     * @param amount control the number of created item
     * @return a backpack with loot added
     */
    public Backpack createMonsterBackpack(List<String> types, Integer amount) {
        LootConfig lootConfig = GameEngine.getInstance().getLootConfig();
        int minPower = lootConfig.getMinPower();
        int maxPower = lootConfig.getMaxPower();
        MonsterBackpack backpack = new MonsterBackpack();
        for (String type : types) {
            generateLoot(backpack, type, minPower, maxPower);
        }
        return backpack;
    }

    public void addItemToBackpack(Backpack backpack, int id) {
            Item item = allItems.get(id);
            backpack.addItem(item);
            System.out.println(item.getName() + "added to backpack" );
    }

    /**
     * Generate random item for backpack as loot.
     * if minPower and maxPower is in unreasonable range, still generate an item in valid range.
     *
     * @param backpack the backpack used to add loot
     * @param type type of item
     * @param minPower min power of the generated loot
     * @param maxPower max power of the generated loot
     */
    public void generateLoot(Backpack backpack, String type, int minPower, int maxPower) {
        Random random = new Random();
        String name;
        int power;

        switch (type) {
            case "W" -> { // weapon
                name = "Small Sword"; // might need to change the name later

                power = random.nextInt(minPower, maxPower);
                Weapon newItem = createWeapon(name, power);
                backpack.addItem(newItem);
            }
            case "P" -> { // potion
                name = "Small HP Potion"; // might need to change the name later

                power = random.nextInt(minPower, maxPower);
                Potion newItem = createPotion(name, power);
                backpack.addItem(newItem);
            }
            case "K" -> { // key
                name = "key";
            }
        }
    }

    /**
     * Player get all loot from monster backpack.
     * @param playerBackpack the backpack of player
     * @param monsterBackpack the backpack of beaten monster
     */
    public void getLootFromBackpack(PlayerBackpack playerBackpack, MonsterBackpack monsterBackpack) {
        for (Item item : monsterBackpack.getItems()) {
            playerBackpack.addItem(item);
        }
        monsterBackpack.clearBackpack();
    }


//    /**
//     *
//     * @return backpack created for player role
//     */
//    public Backpack createPlayerBackpack(){
//        return  new PlayerBackpack();
//    }

    // Method to view all items in the inventory
    public List<Item> getAllItems() {
        return new ArrayList<>(allItems);  // Returns a copy of the items list
    }

    @Override
    public String toString() {
        return "backpack.Inventory{" +
                "items=" + allItems +
                '}';
    }
}

