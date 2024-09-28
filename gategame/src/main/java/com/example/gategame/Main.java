package com.example.gategame;


import com.example.gategame.control.Control;
import com.example.gategame.control.Location;
import com.example.gategame.items.Item;
import com.example.gategame.items.gate.Gate;
import com.example.gategame.items.gate.GateKey;
import com.example.gategame.items.general.weapon.NormalWeapon;
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
            boolean win = false;
            boolean bagFlag  = game.bagFlag;
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

            if(!bagFlag){
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
                                if(stage == 3){
                                    win = true;
                                    return new Game(player,gameMaps,mapItemsList,stage+1,location,bagFlag,win);
                                }else {
                                    Location start = new Location(1,1);
                                    gameMaps.get(stage).displayMap(start,mapItemsList.get(stage));
                                    return new Game(player,gameMaps,mapItemsList,stage+1,start,bagFlag,win);
                                }

                            }
                        } else {
                            System.out.println("Invalid move!");
                        }
                    } else if (order == 'M') {
                        gameMap.displayMap(location,mapItems);
                    } else if (order == 'P') {
                        System.out.println(player.toString());
                    }else if(order == 'I'){
                        bagFlag = true;
                        player.getBackpack().displayItem();
                        System.out.println("open backpack");
                    }
                }
            }else{
                char order = input.charAt(0);
                if(order == 'B'){
                    bagFlag = false;
                    gameMap.displayMap(location,mapItems);
                }else if(Pattern.matches("[0-9]*",input)){
                    int index = Integer.parseInt(input);;
                    if(index>player.getBackpack().getSize()){
                        System.out.println("do not have such item");
                    }else {
                        Item item = player.getBackpack().getItem(index);
                        player.getBackpack().useItem(item,player);
                        System.out.println(player);
                        player.getBackpack().displayItem();
                    }

                }else {
                    System.out.println("Invalid input!");
                }

            }


            mapItemsList.set(stage-1,mapItems);

            if(stage==3 && location.equals(new Location(15,28)))
                win = true;
            return new Game(player,gameMaps,mapItemsList,stage,location,bagFlag,win);

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
                }else if(mapItems.get(location) instanceof GateKey){{
                    for (HashMap.Entry<Location, MapItem> entry : mapItems.entrySet()) {
                        if (entry.getValue() instanceof Gate) {
                            ((Gate) entry.getValue()).open();
                            break;
                        }
                    }
                    mapItems.remove(location);
                    System.out.println("Gate is Open! ");
                    }
                }
                else{
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
//            game.getPlayer().getBackpack().displayItem();
//            Item i2 = game.getPlayer().getBackpack().getItem(4);
//            game.getPlayer().getBackpack().useItem(i2,game.getPlayer());
//            System.out.println(game.getPlayer());
//            Item i2 = game.getPlayer().getBackpack().getItem(5);
//            game.getPlayer().getBackpack().useItem(i2,game.getPlayer());
//            System.out.println(game.getPlayer().getDamage());


            int hp;
            while (true) {
                game = gameLoop(game);
                hp = game.getPlayer().getHealth();
                boolean win = game.win;
                if(hp<=0){
                    System.out.println("you dead");
                    break;
                }
                if(win){
                    System.out.println("You win!");
                    break;
                }
            }
        }
    }
