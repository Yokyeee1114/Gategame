package com.example.gategame.backpack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yeming
 * Genaral backpack with simple abilities such as add/remove items.
 */
public class GeneralBackPack implements Backpack{
    private List<Item> items;
    public GeneralBackPack() {
        items = new ArrayList<Item>();
    }
    @Override
    public void addItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    /**
     * remove item based on item id
     *
     * @param id the id of item
     * @return true if success, false otherwise
     */
    @Override
    public boolean removeItem(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                items.remove(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayItem() {
        System.out.println("Backpack{" +
                ", items=" + items +
                '}');
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public void clearBackpack() {
        items.clear();
    }

    @Override
    public boolean containsItem(Item item) {
        return items.contains(item);
    }
}
