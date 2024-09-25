package com.example.gategame.battle;

import com.example.gategame.role.Monster;
import com.example.gategame.role.Player;
import com.example.gategame.utils.PrintUtils;

/**
 * @author Hao Ye(u7981083)
 * Battle Field encapsulate the battle strategy and show the course of battle.
 */
public class BattleField {


    /**
     * Player and Monster take turns to attack until the other one dies.
     * @param player the role take first attack
     * @param monster the opponent of player
     */
    public static void battle(Player player, Monster monster) {
        PrintUtils.print("Battle Start: ");
        while (player.isAlive() && monster.isAlive()) {
            player.attack(monster);
            if (monster.isAlive()) {
                monster.attack(player);
            }
        }
    }

}
