package com.example.gategame.map;

import com.example.gategame.control.Location;

public class Enemy implements MapObject{
    private final Location location;
    public MapItem mapItem;

    public Enemy(Location location) {
        this.location = location;
    }

    public MapItem getMapItem() {
        return mapItem;
    }

    public void setMapItem(MapItem mapItem) {
        this.mapItem = mapItem;
    }

    public char getSymbol() {
        return mapItem.getSymbol();
    }
    public int getRow() { return location.getRow(); }
    public int getCol() { return location.getCol(); }


}
