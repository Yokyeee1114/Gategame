package com.example.gategame.role;

import com.example.gategame.GameEngine;
import com.example.gategame.backpack.Backpack;
import com.example.gategame.backpack.Inventory;
import com.example.gategame.role.monster.*;
import com.example.gategame.settings.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hao Ye(u7981083)
 * Used to create monsters and player
 */
public class RoleFactory {

    private static MonstersConfig monstersConfig;

    /**
     * create different type of monster based on config
     *
     * @param type
     * @return
     */
    public static Monster createMonster(MonsterType type) {
        if (monstersConfig == null) {
            monstersConfig = GameEngine.getInstance().getMonsterConfig();
        }
        Monster monster = null;
        switch (type) {
            case MINOR -> {
                MonsterConfig monsterConfig = monstersConfig.getMinor();
                Backpack backpack = Inventory.getInventory().createMonsterBackpack("minion", monsterConfig.getLootItems(), monsterConfig.getLootAmount());
                monster = new MinorMonster(monsterConfig.getPower(), monsterConfig.getHealth(), backpack);
            }
            case ELITE -> {
                MonsterConfig monsterConfig = monstersConfig.getElite();
                Backpack backpack = Inventory.getInventory().createMonsterBackpack("elite", monsterConfig.getLootItems(), monsterConfig.getLootAmount());
                monster = new EliteMonster(monsterConfig.getPower(), monsterConfig.getHealth(), backpack);
            }
            case BOSS -> {
                MonsterConfig monsterConfig = monstersConfig.getBoss();
                Backpack backpack = Inventory.getInventory().createMonsterBackpack("boss", monsterConfig.getLootItems(), monsterConfig.getLootAmount());
                monster = new BossMonster(monsterConfig.getPower(), monsterConfig.getHealth(), backpack);
            }
        }
        return monster;
    }

    public static List<Monster> createManyMonsters(MonsterType type, int amount) {
        List<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            monsters.add(createMonster(type));
        }
        return monsters;
    }

    private static PlayerConfig playerConfig;

    public static Player createPlayer() {
        if (playerConfig == null) {
            playerConfig = GameEngine.getInstance().getPlayerConfig();
        }
        Player player = new Player(playerConfig.getName(), "", playerConfig.getPower(), playerConfig.getHealth());
        // initialize player backpack
        List<ItemConfig> initialItems = playerConfig.getInitialItems();
        if (initialItems != null) {
            for (ItemConfig itemConfig : initialItems) {
                player.getBackpack().addItem(itemConfig.createItem());
            }
        }
        return player;
    }

    /**
     * Create all monsters for current level
     *
     * @return
     */
    public static List<Monster> createLevelMonsters() {
        LevelConfig levelConfig = GameEngine.getInstance().getCurrentLevelConfig();
        MapObjectConfig objectConfig = levelConfig.getObjects();
        List<Monster> monsters = new ArrayList<>();
        monsters.addAll(createManyMonsters(MonsterType.MINOR, objectConfig.getMinor()));
        monsters.addAll(createManyMonsters(MonsterType.ELITE, objectConfig.getElite()));
        monsters.addAll(createManyMonsters(MonsterType.BOSS, objectConfig.getBoss()));
        return monsters;
    }
}
