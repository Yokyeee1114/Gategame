package com.example.gategame.map;

import com.example.gategame.control.Location;
import com.example.gategame.role.MinorMonster;
import com.example.gategame.role.Monster;

public class Enemy implements MapObject{
    private final Location location;
    public Monster monster;

    public Enemy(Location location) {
        this.location = location;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public char getSymbol() { return monster.getSymbol(); }
    public int getRow() { return location.getRow(); }
    public int getCol() { return location.getCol(); }


}
