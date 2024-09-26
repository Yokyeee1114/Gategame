package com.example.gategame.backpack;

import com.example.gategame.items.Item;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Yeming Chen
 * backpack for monster, has the basic ability such as add/remove item.
 */
public class MonsterBackpack implements Backpack{
    private List<Item> items;
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
        System.out.println("MonsterBackpack{" +
                ", items=" + items +
                '}');
    }

    public List<Item> getItems() {
        return items;
    }

    public void clearBackpack(){
        items.clear();
    }

    @Override
    public boolean containsItem(Item item) {
        return items.contains(item);
    }

    public MonsterBackpack() {
        this.items = new ArrayList<>();
    }
}
