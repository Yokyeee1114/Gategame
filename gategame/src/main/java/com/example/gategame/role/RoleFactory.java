package com.example.gategame.role;

import com.example.gategame.GameEngine;
import com.example.gategame.backpack.Backpack;
import com.example.gategame.backpack.Inventory;
import com.example.gategame.backpack.Item;
import com.example.gategame.backpack.PlayerBackpack;
import com.example.gategame.settings.ItemConfig;
import com.example.gategame.settings.MonsterConfig;
import com.example.gategame.settings.MonstersConfig;
import com.example.gategame.settings.PlayerConfig;

import java.util.List;

/**
 * @author Hao Ye(u7981083)
 * Used to create monsters
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

    private static PlayerConfig playerConfig;

    public static Player createPlayer() {
        if (playerConfig == null) {
            playerConfig = GameEngine.getInstance().getSettingsConfig().getPlayerConfig();
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

}
