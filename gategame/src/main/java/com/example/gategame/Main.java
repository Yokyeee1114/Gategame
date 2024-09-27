package com.example.gategame;


import com.example.gategame.control.Control;
import com.example.gategame.control.Location;
import com.example.gategame.items.gate.Gate;
import com.example.gategame.map.GameMap;
import com.example.gategame.map.MapItem;
import com.example.gategame.map.MapObject;
import com.example.gategame.role.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


    /**
     * @author Hao Ye(u7981083)
     */
    public class Main {

        public GameMap gameInit() {
            //read json file
            return null;
        }
        public  static List<List<MapObject>> extractMapObjects( List<HashMap<Location, MapObject>> mapObjects) {
            List<List<MapObject>> objectList = new ArrayList<>();

            for (HashMap<Location, MapObject> map : mapObjects) {
                List<MapObject> row = new ArrayList<>(map.values());
                objectList.add(row);
            }
            return objectList;
        }

        public static Game gameLoop(Game game) {
            Player player = game.getPlayer();
            List<GameMap> gameMaps = game.getGameMaps();
            List<HashMap<Location, MapItem>> mapItemsList = game.getMapItemsList();
            int stage = game.getStage();
            Location location = game.getPlayerLocation();

            HashMap<Location,MapItem> mapItems = mapItemsList.get(stage-1);
            GameMap gameMap = gameMaps.get(stage-1);

            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine().toUpperCase();

            if(input.length()==0){
                return game;
            }

            if(input.length()>1){
                if(Pattern.matches("[WASD]*",input)){
                    Location startLocation = location;
                    char[] inputs = input.toCharArray();
                    for (int i = 0; i < inputs.length ; i++) {
                        char order = inputs[i];
                        if (gameMap.isValidMove(Control.move(order, location)) && !isEvent(Control.move(order, location),mapItems)) {
                            location = Control.move(order, location);
                        } else {
                            System.out.println("Invalid move!");
                            location = startLocation;
                            break;
                        }
                    }
                    gameMap.displayMap(location,mapItems);
                }
            }else {
                char order = input.charAt(0);
                if (Pattern.matches("[WASD]", String.valueOf(order))) {
                    if (gameMap.isValidMove(Control.move(order, location))) {
                        location = Control.move(order, location);
                        boolean stageChange = eventTrigger(location, mapItems, player);
                        if(player.isAlive()){
                            gameMap.displayMap(location,mapItems);}
                        if(stageChange){
                            Location start = new Location(1,1);
                            gameMaps.get(stage).displayMap(start,mapItemsList.get(stage));
                            return new Game(player,gameMaps,mapItemsList,stage+1,start);

                        }

                    } else {
                        System.out.println("Invalid move!");
                    }
                } else if (order == 'M') {
                    gameMap.displayMap(location,mapItems);
                } else if (order == 'P') {
                    System.out.println(player.toString());
                }
            }
            mapItemsList.set(stage-1,mapItems);
            return new Game(player,gameMaps,mapItemsList,stage,location);

        }



        public static boolean isEvent(Location location, HashMap<Location, MapItem> mapObject){
            List<Location> locations = new ArrayList<>(mapObject.keySet());
            return locations.contains(location);
        }


        public static boolean eventTrigger(Location location, HashMap<Location,MapItem> mapItems, Player player){
            List<Location> locations = new ArrayList<>(mapItems.keySet());
            if(locations.contains(location)){


                if(mapItems.get(location) instanceof Gate){
                    if(((Gate) mapItems.get(location)).isLocked()){
                        System.out.println("the gate is locked");
                    }else {
                        return true;
                    }
                }else {
                    mapItems.get(location).interact(player);
                    mapItems.remove(location);
                }
            }
            return false;
        }


        public static void main(String[] args) {
            GameEngine.getInstance().loadEngine();
//            Enemy a = new Enemy(location, );
//            HashMap<Location,MapObject> hashMap = new HashMap<>();
//            hashMap.put(location, (MapObject) a);
            Game game = new Game();
            game.initGame();
            int hp;
            while (true) {
                game = gameLoop(game);
                hp = game.getPlayer().getHealth();
                if(hp<=0){
                    System.out.println("you dead");
                    break;
                }
            }

//            Player player = new Player("a","test",10,100);
//            Monster a = new MinorMonster(1,100,null);
//            BattleField.battle(player,a);
//            System.out.println(player.getHealth());


////            List<MapObject> mapObjects = game.getMapObjects()
//            game.getGameMaps().get(0).displayMap(1,1);

        }


            //just for test, it can be changed to Utility class later
//            String[] mapData = {
//                    "####.####",
//                    "#...#...#",
//                    "#.#...#.#",
//                    "#.#####.#",
//                    "#.......#",
//                    "#########"
//            };
////
//            GameMap gameMap = new GameMap(mapData);
//            Location location = new Location(1, 1);
////        //display the location of player
////        if (gameMap.isValidMove(playerLocation)){
////            gameMap.displayMap(playerLocation);
////        }else {
////            System.out.println("Invalid!");
////        }
////        Scanner scanner = new Scanner(System.in);
//
//            ArrayList<Location> locations = new ArrayList<>();
//            locations.add(new Location(2,1));
////            gameMap.displayMap(location);
//

//        }
    }
