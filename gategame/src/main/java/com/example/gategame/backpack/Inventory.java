package com.example.gategame.backpack;

import com.example.gategame.equipment.HpPotion;
import com.example.gategame.equipment.NormalWeapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yeming Chen
 * Inventory system used to manage all items in the game
 */
public class Inventory {
    private List<Item> allItems;  // List to hold items
    private static Inventory inventory = null;
    private Map<String, Backpack> backpacks;

    public Inventory() {
        this.allItems = new ArrayList<>();
        this.backpacks = new HashMap<>();
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
    public Item createWeapon(int id, String name, int power) {
        // create and add to the inventory
        Item newItem = new NormalWeapon(id, name, power);
        allItems.add(newItem);
        return newItem;
    }

    public Item createPotion(int id, String name, int power) {
        // create and add to the inventory
        Item newItem = new HpPotion(id, name, power);
        allItems.add(newItem);
        return newItem;
    }

    public void registerBackpack(String identifier, Backpack backpack) {
        backpacks.put(identifier, backpack);
    }

    public Backpack getBackpacks(String identifier) {
        if (backpacks.containsKey(identifier)) {
            return backpacks.get(identifier);
        }
        return null;
    }

    public void addItemToBackpack(String identifier, int id) {
        if (backpacks.containsKey(identifier)) {
            Item item = allItems.get(id);
            backpacks.get(identifier).addItem(item);
            System.out.println("Global Inventory: Added " + item.getName() + " to " + identifier);
        }
    }



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

