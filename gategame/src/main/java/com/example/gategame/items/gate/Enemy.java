package com.example.gategame.items.gate;

import com.example.gategame.battle.BattleField;
import com.example.gategame.control.Location;
import com.example.gategame.map.MapItem;
import com.example.gategame.role.Monster;
import com.example.gategame.role.Player;

public class Enemy implements MapItem {

    private Monster monster;

    public Enemy(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    @Override
    public Character getSymbol() {
        return monster.getSymbol();
    }

    @Override
    public void interact(Player player) {
        BattleField.battle(player,monster);
    }



}
