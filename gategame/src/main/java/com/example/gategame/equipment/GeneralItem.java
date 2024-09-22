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
    private Location location;

    public GeneralItem(int id, String name, int power) {
        this.name = name;
        this.power = power;
        this.id = id;
    }

    public GeneralItem(int id, String name, int power, Location location) {
        this.name = name;
        this.power = power;
        this.id = id;
        this.location = location;
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

    @Override
    public boolean hasLocation() {
        return this.location != null;
    }

    @Override
    public Location getLocation() {
        return location;
    }
}
