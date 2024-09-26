package com.example.gategame.backpack;

import com.example.gategame.items.Item;

/**
 * @author Yeming Chen
 * Backpack is used to store/use item
 */

public interface Backpack {
    void addItem(Item item);
    boolean removeItem(int id);
    void displayItem();

    /**
     * useful for identify existence of specific item
     *
     * @param item check if this item is in backpack.
     */
    boolean containsItem(Item item);
}
