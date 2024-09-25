package com.example.gategame.backpack;

import com.example.gategame.equipment.Potion;
import com.example.gategame.equipment.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yeming Chen
 * backpack for player, and add/use item inside
 */
public class PlayerBackpack implements Backpack {
    //    Role role;
    private List<Item> items;


    public PlayerBackpack() {
//        this.role = role;
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(Item item){
        if (item != null) {
            items.add(item);
            sortItems();
            System.out.println("item " + item.getName() + " added");
        }
    }

    /**
     * sort items by potion -> weapon -> other
     */
    public void sortItems() {
        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                // compare type first
                int typeOrder1 = getItemTypePriority(item1);
                int typeOrder2 = getItemTypePriority(item2);

                if (typeOrder1 != typeOrder2) {
                    return Integer.compare(typeOrder1, typeOrder2);
                }

                // then compare index
                return Integer.compare(item1.getId(), item2.getId());
            }
            private int getItemTypePriority(Item item) {
                if (item instanceof Potion) {
                    return 1;  // Potion first
                } else if (item instanceof Weapon) {
                    return 2;  // then Weapon
                } else {
                    return 3;  // others
                }
            }
        });
    }

    @Override
    public boolean removeItem(int id) {
        if(id >= items.size()) return false;
        items.remove(id);
        return true;
    }

    /**
     * get and remove item in the backpack
     * @param id the index of item in backpack, not the global index
     * @return The item of given index, null if item not found.
     */
    public Item getItem(int id) {
        if(id >= items.size()) {
            System.out.println("item " + id + " not found");
            return null;
        }
        Item item = items.get(id);
        items.remove(item);
        System.out.println("item " + item.getName() + " removed");
        return item;
    }

    /**
     * Method to find all potion
     * @return a list of all potion in the backpack
     */
    public List<Potion> getPotions() {
        return items.stream()
                .filter(item -> item instanceof Potion)
                .map(item -> (Potion) item)
                .collect(Collectors.toList());
    }

    /**
     * Method to find all weapons
     * @return a list of all weapons in the backpack
     */
    public List<Weapon> getWeapons() {
        return items.stream()
                .filter(item -> item instanceof Weapon)
                .map(item -> (Weapon) item)
                .collect(Collectors.toList());
    }

    @Override
    public void displayItem() {
        System.out.println("playerBackpack{");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("id " + i + ": " + items.get(i));
        }
        System.out.println("}");
    }

    @Override
    public boolean containsItem(Item item) {
        return items.contains(item);
    }

}
