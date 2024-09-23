package com.example.gategame.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameSystem {
    private List<GameMap> maps;
    private int currentMapIndex;
    private int playerRow;
    private int playerCol;
    private Scanner scanner;
    public GameSystem() {
        maps = new ArrayList<>();
        currentMapIndex = 0;
        scanner = new Scanner(System.in);


        initializeMaps();

    }
    private void initializeMaps() {
        // map2:easy
        GameMap map1 = new GameMap(new String[]{
                "########D########",
                "#..............##",
                "#.####.#####.#.##",
                "#.#.........#.###",
                "#.#.#######.#.###",
                "#...#.....#...###",
                "###########.#####"
        }, null);
        map1.addMapObject(new HealPackTest(1, 5));
        map1.addMapObject(new WeaponTest(3, 7));
        map1.addMapObject(new EnemyTest(5, 10));
        maps.add(map1);

        GameMap map2 = new GameMap(new String[]{
                "###################",
                "#........#.......D#",
                "#.######.#.#####.##",
                "#......#.#.#...#.##",
                "######.#.#.#.#.#.##",
                "#....#.#.#.#.#.#.##",
                "#.##.#.#.#.#.#.#.##",
                "#..#.#.....#.#...##",
                "#.##.#######.######",
                "#................##",
                "###################"
        }, null);
        map2.addMapObject(new HealPackTest(1, 5));
        map2.addMapObject(new WeaponTest(3, 7));
        map2.addMapObject(new EnemyTest(5, 10));
        maps.add(map2);


        GameMap map3 = new GameMap(new String[]{
                "########################",
                "#..........#...........#",
                "#.########.#.#########.#",
                "#.#......#.#.#.......#.#",
                "#.#.####.#.#.#.#####.#.#",
                "#.#.#..#.#.#.#.#...#.#.#",
                "#.#.#.##.#.#.#.#.#.#.#.#",
                "#.#.#....#.#.#.#.#.#.#.#",
                "#.#.######.#.#.#.#.#.#.#",
                "#.#........#.#.#.#.#.#.#",
                "#.##########.#.#.#.#.#.#",
                "#............#...#.#.#D#",
                "########################"
        }, null);
        map3.addMapObject(new HealPackTest(1, 5));
        map3.addMapObject(new WeaponTest(3, 7));
        map3.addMapObject(new EnemyTest(5, 10));
        maps.add(map3);

        // initialize the location of player
        playerRow = 1;
        playerCol = 1;

    }

    /**
     * @author Yuheng Li
     *
     */
    public void play() {
        while (currentMapIndex < maps.size()) {
            GameMap currentMap = maps.get(currentMapIndex);
            currentMap.displayMap(playerRow, playerCol);

            System.out.println("Input the direction (W:up, S:down, A:left, D:right, Q:quit):");
            String input = scanner.nextLine().toUpperCase();

            if (input.equals("Q")) {
                System.out.println("Game over");
                break;
            }
            movePlayer(input, currentMap);

            // check the items of the player's location
            MapObject obj = currentMap.getObjectAt(playerRow, playerCol);
            if (obj != null) {
                handleMapObject(obj);
            }

            if (currentMap.isDoor(playerRow, playerCol)) {
                System.out.println("Cheers! Go to next level!");
                currentMapIndex++;
                if (currentMapIndex < maps.size()) {
                    playerRow = 1;
                    playerCol = 1;
                }
            }
        }

        if (currentMapIndex == maps.size()) {
            System.out.println("Cheers! You finish all map!");
        }
        scanner.close();
    }

    /**
     * @author Yuheng Li
     * @param direction
     * @param currentMap
     */
    private void movePlayer(String direction, GameMap currentMap) {
        int newRow = playerRow;
        int newCol = playerCol;

        switch (direction) {
            case "W": newRow--; break;
            case "S": newRow++; break;
            case "A": newCol--; break;
            case "D": newCol++; break;
            default:
                System.out.println("Invalid input");
                return;
        }

        if (currentMap.isValidMove(newRow, newCol)) {
            playerRow = newRow;
            playerCol = newCol;
        } else {
            System.out.println("Invalid position");
        }
    }

    /**
     * @author Yuheng Li
     * @param obj
     */
    private void handleMapObject(MapObject obj) {
        if (obj instanceof HealPackTest) {
            System.out.println("You have found a healing pack!");
        } else if (obj instanceof WeaponTest) {
            System.out.println("You have found a weapon!");
        } else if (obj instanceof EnemyTest) {
            System.out.println("You have met a enemy!");
        }
    }
}

