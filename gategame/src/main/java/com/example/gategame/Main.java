package com.example.gategame;


import com.example.gategame.battle.BattleField;
import com.example.gategame.role.Monster;
import com.example.gategame.role.Player;

/**
 * @author Hao Ye(u7981083)
 */
public class Main {
    public static void main(String[] args) {
        Player player = new Player("Hero", "", 15, 100);
        Monster monster = new Monster("Goblin", "",10, 50);
        BattleField.battle(player,monster);
    }
}