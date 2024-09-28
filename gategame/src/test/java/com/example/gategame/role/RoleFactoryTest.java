package com.example.gategame.role;

import com.example.gategame.GameEngine;
import com.example.gategame.role.monster.*;
import com.example.gategame.settings.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Hao Ye(u7981083)
 * Test role factory's compliance with config
 */
class RoleFactoryTest {

    static MonstersConfig monstersConfig;
    static SettingsConfig settingsConfig;
    static LevelConfig currentLevelConfig;

    @BeforeAll
    static void beforeAll() {
        GameEngine.getInstance().loadEngine();
        settingsConfig = GameEngine.getInstance().getSettingsConfig();
        monstersConfig = GameEngine.getInstance().getMonsterConfig();
        currentLevelConfig = GameEngine.getInstance().getCurrentLevelConfig();
    }

    @BeforeEach
    void setUp() {
        monstersConfig.setMinor(new MonsterConfig(MonsterType.MINOR, new ArrayList<>(), 0, 10, 100));
        monstersConfig.setElite(new MonsterConfig(MonsterType.ELITE, new ArrayList<>(), 0, 20, 200));
        settingsConfig.setPlayerConfig(new PlayerConfig("Test", 10, 100, new ArrayList<>()));
        currentLevelConfig.setObjects(new MapObjectConfig(3, 2, 1));
    }

    @Test
    @DisplayName("Create minor monster based on config")
    void createMonster() {
        Monster monster = RoleFactory.createMonster(MonsterType.MINOR);
        assertNotNull(monster);
        assertEquals(10, monster.getPower());
        assertEquals(100, monster.getHealth());
    }

    @Test
    void createManyMonsters() {
        List<Monster> monsters = RoleFactory.createManyMonsters(MonsterType.ELITE, 5);
        assertNotNull(monsters);
        assertEquals(5, monsters.size());
        assertEquals(20, monsters.get(0).getPower());
        assertEquals(200, monsters.get(0).getHealth());
    }

    @Test
    void createPlayer() {
        Player player = RoleFactory.createPlayer();
        assertNotNull(player);
        assertEquals(10, player.getPower());
        assertEquals(100, player.getHealth());
        assertEquals("Test", player.getName());
    }

    @Test
    void createLevelMonsters() {
        List<Monster> monsters = RoleFactory.createLevelMonsters();
        assertNotNull(monsters);
        assertEquals(6, monsters.size());
        assertEquals(3, monsters.stream().filter(monster -> monster instanceof MinorMonster).toList().size());
        assertEquals(2, monsters.stream().filter(monster -> monster instanceof EliteMonster).toList().size());
        assertEquals(1, monsters.stream().filter(monster -> monster instanceof BossMonster).toList().size());
    }
}