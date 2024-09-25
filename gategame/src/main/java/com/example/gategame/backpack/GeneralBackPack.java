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

    @Override
    public boolean removeItem(int id) {
        if(id >= items.size()) return false;
        items.remove(id);
        return true;
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
