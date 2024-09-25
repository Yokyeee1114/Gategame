package com.example.gategame.backpack;

import com.example.gategame.GameEngine;
import com.example.gategame.equipment.HpPotion;
import com.example.gategame.equipment.NormalWeapon;
import com.example.gategame.equipment.Potion;
import com.example.gategame.equipment.Weapon;
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


    public Weapon createWeapon(String name, int power) {
        // create and add to the inventory
        int id = nextId++;
        NormalWeapon newItem = new NormalWeapon(id, name, power);
        allItems.add(newItem);
        return newItem;
    }

    public HpPotion createPotion(String name, int power) {
        // create and add to the inventory
        int id = nextId++;
        HpPotion newItem = new HpPotion(id, name, power);
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
    public Backpack createMonsterBackpack(String monsterType, List<String> types, Integer amount) {
        //LootConfig lootConfig = GameEngine.getInstance().getLootConfig();
        LootConfig lootConfig = GameEngine.getInstance().getLootRules().getLootConfig(monsterType);
        int minPower = lootConfig.getMinPower();
        int maxPower = lootConfig.getMaxPower();
        int potionRate = lootConfig.getPotionRate();
        MonsterBackpack backpack = new MonsterBackpack();
        for (String type : types) {
            generateLoot(backpack, type, minPower, maxPower, potionRate);
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
     * @param backpack the backpack used to add loot
     * @param type type of item
     * @param minPower min power of the generated loot
     * @param maxPower max power of the generated loot
     * @param potionRate rate of potion's power.
     */
    public void generateLoot(Backpack backpack, String type, int minPower, int maxPower, int potionRate) {
        Random random = new Random();
        String name;
        int power;

        switch (type) {
            case "W" -> { // weapon
                power = random.nextInt(minPower, maxPower);
                name = getItemPrefix(power, "W");
                Weapon newItem = createWeapon(name, power);
                backpack.addItem(newItem);
            }
            case "P" -> { // potion
                power = random.nextInt(minPower, maxPower) * potionRate;
                name = getItemPrefix(power, "P");
                Potion newItem = createPotion(name, power);
                backpack.addItem(newItem);
            }
            case "K" -> { // key
                name = "key";
            }
        }
    }

    /**
     * Generate item name based on power
     * @param power the power of item
     * @param itemType the type of item
     * @return
     */
    public String getItemPrefix(int power, String itemType) {
        String[] weaponTypes = {"Sword", "Axe", "Mace", "Spear"};
        if (itemType.equals("P")) {
            if (power < 10) return "Small Potion";
            else if (power <= 30) return "Medium Potion";
            else return "Large Potion";
        } else if (itemType.equals("W")) {
            Random random = new Random();
            String weaponType = weaponTypes[random.nextInt(weaponTypes.length)];
            if (power < 15) return "Weak " + weaponType;
            else if (power <= 25) return "Strong " + weaponType;
            else return "Mighty " + weaponType;
        } else {
            return ""; // Default prefix for unknown types
        }
    }


    /**
     * Player get all loot from monster backpack.
     * @param playerBackpack the backpack of player
     * @param backpack the backpack of beaten monster
     */
    public void getLootFromBackpack(PlayerBackpack playerBackpack, Backpack backpack) {
        for (Item item : backpack.getItems()) {
            playerBackpack.addItem(item);
        }
        backpack.clearBackpack();
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

