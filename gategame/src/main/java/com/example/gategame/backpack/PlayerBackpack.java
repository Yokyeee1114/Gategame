package com.example.gategame.backpack;

import com.example.gategame.items.general.potion.Potion;
import com.example.gategame.items.general.weapon.Weapon;
import com.example.gategame.items.Item;
import com.example.gategame.items.general.UsableItem;
import com.example.gategame.role.Player;
import com.example.gategame.role.Role;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yeming Chen
 * backpack for player, and add/use item inside
 */
public class PlayerBackpack extends GeneralBackPack {


    public PlayerBackpack() {
        super();
    }

    @Override
    public void addItem(Item item){
        if (item != null) {
            super.addItem(item);
            sortItems();
            System.out.println("item " + item.getName() + " added");
        }
    }

    /**
     * sort items by potion -> weapon -> other
     */
    public void sortItems() {
        getItems().sort(new Comparator<Item>() {
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


    /**
     * get and remove item in the backpack
     * @param id the index of item in backpack, not the global index
     * @return The item of given index, null if item not found.
     */
    public Item getItem(int id) {
        if(id >= getItems().size()) {
            System.out.println("item " + id + " not found");
            return null;
        }
        Item item = getItems().get(id);
        getItems().remove(item);
        System.out.println("item " + item.getName() + " used");
        return item;
    }

    /**
     * Method to find all potion
     * @return a list of all potion in the backpack
     */
    public List<Potion> getPotions() {
        return getItems().stream()
                .filter(item -> item instanceof Potion)
                .map(item -> (Potion) item)
                .collect(Collectors.toList());
    }

    /**
     * Filter items by generic class type
     *
     * @param tClass the item type to retrieve
     * @param <T>    the class for specific item
     * @return the item list
     */
    public <T extends Item> List<T> getItems(Class<T> tClass) {
        return getItems().stream().filter(tClass::isInstance).map(tClass::cast).toList();
    }

    /**
     * Remove the item from backpack before using it.
     *
     * @param item to be used
     * @param player to be affected
     */
    public void useItem(Item item, Player player) {
        if (item instanceof UsableItem) {
            getItems().remove(item);
            ((UsableItem) item).use(player);
        } else {
            System.out.println(item.getName() + " cannot be used.");
        }
    }

    public int getSize(){
        return getItems().size();
    }


    /**
     * Method to find all weapons
     * @return a list of all weapons in the backpack
     */
    public List<Weapon> getWeapons() {
        return getItems().stream()
                .filter(item -> item instanceof Weapon)
                .map(item -> (Weapon) item)
                .collect(Collectors.toList());
    }

    @Override
    public void displayItem() {
        System.out.println("playerBackpack{");
        for (int i = 0; i < getItems().size(); i++) {
            System.out.println("id " + i + ": " + getItems().get(i));
        }
        System.out.println("}");
    }

    @Override
    public boolean containsItem(Item item) {
        return getItems().contains(item);
    }

}
