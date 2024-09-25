package com.example.gategame;


import com.example.gategame.battle.BattleField;
import com.example.gategame.control.Control;
import com.example.gategame.control.Location;
import com.example.gategame.map.Enemy;
import com.example.gategame.map.GameMap;
import com.example.gategame.map.MapObject;
import com.example.gategame.role.*;
import com.example.gategame.Game;

import java.util.*;
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
            List<HashMap<Location, MapObject>> mapObjects = game.getMapObjects();
            int stage = game.getStage();
            Location location = game.getPlayerLocation();

            HashMap<Location,MapObject> mapObject = game.getMapObjects().get(stage-1);
            GameMap gameMap = gameMaps.get(stage-1);
            gameMap.setMapObjects(extractMapObjects(mapObjects).get(stage-1));

            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine().toUpperCase();

            if(input.length()>1){
                if(Pattern.matches("[WASD]*",input)){
                    Location startLocation = location;
                    char[] inputs = input.toCharArray();
                    for (int i = 0; i < inputs.length ; i++) {
                        char order = inputs[i];
                        if (gameMap.isValidMove(Control.move(order, location)) && !isEvent(Control.move(order, location),mapObject)) {
                            location = Control.move(order, location);
                        } else {
                            System.out.println("Invalid move!");
                            location = startLocation;
                            break;
                        }
                    }
                    gameMap.displayMap(location);
                }
            }else {
                char order = input.charAt(0);
                if (Pattern.matches("[WASD]", String.valueOf(order))) {
                    if (gameMap.isValidMove(Control.move(order, location))) {
                        location = Control.move(order, location);
                        mapObject = eventTrigger(location,mapObject,player);
                        if(player.isAlive()){
                        gameMap.displayMap(location);}

                    } else {
                        System.out.println("Invalid move!");
                    }
                } else if (order == 'M') {
                    gameMap.displayMap(location);
                } else if (order == 'P') {
                    System.out.println("HP: "+player.getHealth()+"  ATK: "+player.getDamage());
                }
            }
            mapObjects.set(stage-1,mapObject);
            return new Game(player,gameMaps,mapObjects,stage,location);

        }

        public static List<Location> getEventLocation(HashMap<Location,MapObject> mapObject){
            return new ArrayList<>(mapObject.keySet());
        }

        public static boolean isEvent(Location location, HashMap<Location, MapObject> mapObject){
            List<Location> locations = getEventLocation(mapObject);
            return locations.contains(location);
        }


        public static HashMap<Location,MapObject> eventTrigger(Location location, HashMap<Location,MapObject> mapObject, Player player){
            List<Location> locations = getEventLocation(mapObject);
            if(locations.contains(location)){
                if(mapObject.get(location) instanceof Enemy){
                    BattleField.battle(player,((Enemy) mapObject.get(location)).getMonster());
                }
                mapObject.remove(location);
            }

            return mapObject;
        }


        public static void main(String[] args) {

//            Enemy a = new Enemy(location, );
//            HashMap<Location,MapObject> hashMap = new HashMap<>();
//            hashMap.put(location, (MapObject) a);
            Game game = new Game();
            game.initGame();
            int hp = game.getPlayer().getHealth();
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
