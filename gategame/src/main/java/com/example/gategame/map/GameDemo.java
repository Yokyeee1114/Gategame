package com.example.gategame.map;

import java.util.Map;

public class GameDemo {
    public static void main(String[] args) {
        //just for test, it can be changed to Utility class later
        String[] mapData = {
                "####.####",
                "#...#...#",
                "#.#...#.#",
                "#.#####.#",
                "#.......#",
                "#########"
        };

        GameMap gameMap = new GameMap(mapData);
        int pRow = 1;
        int pCol = 1;
        //display the location of player
        if (gameMap.isValidMove(pRow,pCol)){
            gameMap.displayMap(pRow, pCol);
        }else {
            System.out.println("Invalid!");
        }
    }
}
