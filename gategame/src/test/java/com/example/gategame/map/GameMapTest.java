package com.example.gategame.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameMapTest {
    private GameMap map;
    String[] mapData = {
            "####D####",
            "#...#...#",
            "#.#...#.#",
            "#.#####.#",
            "#.......#",
            "#########"
    };
    @Test
    public void testMapCreation() {
        map = new GameMap(mapData);
        assertNotNull(map);
    }

    @Test
    public void testValidMove() {
        assertTrue(map.isValidMove(1, 1));
        assertTrue(map.isValidMove(0, 4));
        assertFalse(map.isValidMove(0, 0));
        assertFalse(map.isValidMove(-1, 0));
    }

    @Test
    public void testDoorDetection() {
        assertTrue(map.isDoor(0, 4));
        assertFalse(map.isDoor(1, 1));
    }

    @Test
    public void testAddMapObject() {
        MapObject healingPack = new HealPackTest(1, 1);
        map.addMapObject(healingPack);
        assertEquals(healingPack, map.getObjectAt(1, 1));
    }

    @Test
    public void testMultipleMapObjects() {
        MapObject healingPack = new HealPackTest(1, 1);
        MapObject weapon = new WeaponTest(2, 2);
        MapObject enemy = new EnemyTest(3, 3);

        map.addMapObject(healingPack);
        map.addMapObject(weapon);
        map.addMapObject(enemy);

        assertEquals(healingPack, map.getObjectAt(1, 1));
        assertEquals(weapon, map.getObjectAt(2, 2));
        assertEquals(enemy, map.getObjectAt(3, 3));
        assertNull(map.getObjectAt(4, 4));
    }

    @Test
    public void testMapObjectSymbols() {
        assertEquals('+', new HealPackTest(0, 0).getSymbol());
        assertEquals('W', new WeaponTest(0, 0).getSymbol());
        assertEquals('E', new EnemyTest(0, 0).getSymbol());
    }

}