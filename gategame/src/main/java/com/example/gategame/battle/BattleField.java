package com.example.gategame.battle;

import com.example.gategame.role.Monster;
import com.example.gategame.role.Player;
import utils.PrintUtils;

import java.util.ArrayList;
import java.util.List;

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
    public static void battle(Player player, Monster monster){
        List<String> battleHistory = new ArrayList<>();
        while (player.isAlive() && monster.isAlive()){
            battleHistory.addAll(player.attack(monster));
            if(monster.isAlive()){
                battleHistory.addAll(monster.attack(player));
            }
        }
        // show the course of battle
        PrintUtils.print("Battle Start: ");
        for (String s : battleHistory) {
            PrintUtils.print(s);
        }
    }


}
