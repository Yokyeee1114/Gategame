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
        // map1:easy
        maps.add(new GameMap(new String[]{
                "################",
                "#..............#",
                "#.####.#####.#.#",
                "#.#.........#.##",
                "#.#.#######.#.##",
                "#...#.....#...##",
                "###########D####"
        }));

        // map2 :mid
        maps.add(new GameMap(new String[]{
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
        }));

        // map3: hard
        maps.add(new GameMap(new String[]{
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
        }));

        // initialize the location of player
        playerRow = 1;
        playerCol = 1;
    }

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
}

