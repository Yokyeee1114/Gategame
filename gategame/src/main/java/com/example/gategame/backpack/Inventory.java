package com.example.gategame.backpack;

import com.example.gategame.equipment.HpPotion;
import com.example.gategame.equipment.NormalWeapon;
import com.example.gategame.equipment.Potion;
import com.example.gategame.equipment.Weapon;

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
        Weapon newItem = new NormalWeapon(id, name, power);
        allItems.add(newItem);
        return newItem;
    }

    public Potion createPotion(String name, int power) {
        // create and add to the inventory
        int id = nextId++;
        Potion newItem = new HpPotion(id, name, power);
        allItems.add(newItem);
        return newItem;
    }

    public PlayerBackpack createBackpack() {
        return new PlayerBackpack();
    }

    public void addItemToBackpack(Backpack backpack, int id) {
            Item item = allItems.get(id);
            backpack.addItem(item);
            System.out.println(item.getName() + "added to backpack" );
    }

    /**
     * Generate random item for backpack as loot.
     * @param backpack the backpack used to add loot
     * @param minPower min power of the generated loot
     * @param maxPower max power of the generated loot
     */
    public void generateLoot(Backpack backpack, int minPower, int maxPower) {
        Random random = new Random();
        int type = random.nextInt(2);
        String name;
        int power;

        if (type == 0) { // weapon
            name = "Small Sword"; // might need to change the name later
            power = random.nextInt(minPower, maxPower);
            Weapon newItem = createWeapon(name, power);
            backpack.addItem(newItem);
        } else { // potion
            name = "Small HP Potion"; // might need to change the name later
            power = random.nextInt(minPower, maxPower);
            Potion newItem = createPotion(name, power);
            backpack.addItem(newItem);
        }
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

