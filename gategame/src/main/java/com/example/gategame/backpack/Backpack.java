package com.example.gategame.backpack;

/**
 * @author Yeming Chen
 * Backpack is used to store/use item
 */

public interface Backpack {
    void addItem(Item item);
    boolean removeItem(int id);
    void displayItem();
}
