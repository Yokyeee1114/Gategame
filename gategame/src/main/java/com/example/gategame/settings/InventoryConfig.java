package com.example.gategame.settings;

import com.example.gategame.backpack.Inventory;

import java.util.List;

/**
 * @author Yeming
 */
public class InventoryConfig {
    private List<ItemConfig> items;

    public List<ItemConfig> getItems() {
        return items;
    }

    public void setItems(List<ItemConfig> items) {
        this.items = items;
    }

    public void initializeInventory() {
        if (items != null) {
            for (ItemConfig itemConfig : items) {
                itemConfig.createItem();
            }
        }
    }

}
