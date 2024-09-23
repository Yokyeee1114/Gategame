package com.example.gategame.control;

import com.example.gategame.map.GameDemo;
import com.example.gategame.map.GameMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ControlDemo {
//        public static void main(String[] args) {
//        //just for test, it can be changed to Utility class later
//        String[] mapData = {
//                "####.####",
//                "#...#...#",
//                "#.#...#.#",
//                "#.#####.#",
//                "#.......#",
//                "#########"
//        };
//
//        GameMap gameMap = new GameMap(mapData);
//        Location playerLocation = new Location(1,1);
//
//
//
//
//        //display the location of player
//        if (gameMap.isValidMove(playerLocation)){
//            gameMap.displayMap(playerLocation);
//        }else {
//            System.out.println("Invalid!");
//        }
//
//    }


//    public static void main(String[] args) {
//        boolean mapState = true;
//        String[] mapData = {"####.####", "#...#...#", "#.#...#.#", "#.#####.#", "#.......#", "#########"};
//
//        GameMap gameMap = new GameMap(mapData);
//        Location location = new Location(1, 1);
//        gameMap.displayMap(location);
//        while (true) {
//            Scanner scan = new Scanner(System.in);
//            char order = scan.next().toUpperCase().charAt(0);
//
//            if (Pattern.matches("[WASD]", String.valueOf(order))) {
//                if (gameMap.isValidMove(Control.move(order, location))) {
//                    location = Control.move(order, location);
//                    gameMap.displayMap(location);
//                } else {
//                    System.out.println("Invalid move!");
//                }
//            } else if (order == 'M') {
//                gameMap.displayMap(location);
//                mapState = true;
//            } else if (order == 'P') {
//                //show player status here
//            }
//        }
//
//    }
}


