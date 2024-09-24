package com.example.gategame.equipment;

import com.example.gategame.backpack.Item;
import com.example.gategame.control.Location;
import com.example.gategame.role.Role;

/**
 * @author Yeming Chen
 * super class of all general items
 * Have power, name, id, and location.
 * location can be null if it is not displayed in the map.
 */
public class GeneralItem implements Item {
    private String name;
    private int power;
    private int id;

    public GeneralItem(int id, String name, int power) {
        this.name = name;
        this.power = power;
        this.id = id;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void use(Role role) {

    }

    @Override
    public int getId() {
        return id;
    }

    public int getPower() {
        return power;
    }

}
