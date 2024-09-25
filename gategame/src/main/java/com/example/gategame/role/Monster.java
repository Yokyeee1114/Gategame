package com.example.gategame.role;


import com.example.gategame.backpack.Backpack;
import com.example.gategame.battle.BattleField;
import com.example.gategame.map.MapItem;

/**
 * @author Hao Ye(u7981083)
 */
public class Monster extends Role implements MapItem {

    private Backpack backpack;

    public Monster(String name, String description, Integer power, Integer maxHealth, Backpack backpack) {
        super(name, description, power, maxHealth);
        this.backpack = backpack;
    }

    @Override
    public String toString() {
        return String.format("%s: power(%s), health(%s)", getName(), getPower(), getHealth());
    }

    @Override
    public Character getSymbol() {
        return null;
    }

    @Override
    public void interact(Player player) {
        System.out.printf("%s fighting with %s%n", player.getName(), getName());
        BattleField.battle(player, this);
    }
}
