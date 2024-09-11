package com.example.gategame.backpack;

import com.example.gategame.role.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yeming Chen
 * backpack for player, and add/use item inside
 */
public class playerBackpack implements Backpack {
    Role role;
    private List<Item> items;


    public playerBackpack(Role role){
        this.role = role;
        this.items = new ArrayList<Item>();
    }

    @Override
    public void addItem(Item item){
        if (item != null) {
            items.add(item);
            System.out.println("item " + item.getName() + " added");
        }
    }

    @Override
    public boolean removeItem(int id) {
        if(id >= items.size()) return false;
        items.remove(id);
        return true;
    }

    /**
     * use item in the backpack
     * @param id the index of item
     * @return true if successful; false otherwise.
     */
    public boolean useItem(int id) {
        for(Item item : items){
            if (item.getId() == id){
                items.remove(item);
                System.out.println("item " + item.getName() + " removed");
                item.use(role);
                return true;
            }
        }
        System.out.println("item " + id + " not found");
        return false;
    }

    @Override
    public void displayItem() {
        System.out.println("playerBackpack{" +
                "character=" + role.getName() +
                ", items=" + items +
                '}');
    }

}
