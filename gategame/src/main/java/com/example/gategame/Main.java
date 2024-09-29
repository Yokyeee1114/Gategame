package com.example.gategame;


import com.example.gategame.Move.Move;
import com.example.gategame.Move.Location;
import com.example.gategame.items.Item;
import com.example.gategame.items.gate.Gate;
import com.example.gategame.items.gate.GateKey;
import com.example.gategame.map.GameMap;
import com.example.gategame.map.MapItem;
import com.example.gategame.map.MapObject;
import com.example.gategame.role.Player;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


    /**
     * @author Hao Ye(u7981083)
     */
    public class Main {

        static String mapGuide = "Input the direction (W:up, S:down, A:left, D:right, Q:quit) \nInput I to open the backpack, Input P to display player status \nInput M to show the map";
        static String bagGuide = "Input the number of item in bag to use the item \nInput B to back to map.";

        /**
         * @param game
         * @return Game
         * @description gameLoop, main game control system
         * @author Zining He
        */

        public static Game gameLoop(Game game) throws InterruptedException {
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
                System.out.println("Invalid input!");
                return game;
            }

            if(!bagFlag){
                if(input.length()>1){
                    if(Pattern.matches("[WASD]*",input)){
                        Location startLocation = location;
                        char[] inputs = input.toCharArray();
                        for (int i = 0; i < inputs.length ; i++) {
                            char order = inputs[i];
                            if (gameMap.isValidMove(Move.move(order, location)) && !isEvent(Move.move(order, location),mapItems)) {
                                location = Move.move(order, location);
                            } else {
                                System.out.println("Invalid move!");
                                location = startLocation;
                                break;
                            }
                        }
                        Thread.sleep(500);
                        gameMap.displayMap(location,mapItems);
                        System.out.println(mapGuide);
                    }
                }else {
                    char order = input.charAt(0);
                    if (Pattern.matches("[WASD]", String.valueOf(order))) {
                        if (gameMap.isValidMove(Move.move(order, location))) {
                            location = Move.move(order, location);
                            boolean stageChange = eventTrigger(location, mapItems, player);
                            if(player.isAlive()){gameMap.displayMap(location,mapItems);}
                            System.out.println(mapGuide);
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
                        Thread.sleep(500);
                        System.out.println("open backpack");
                        System.out.println(bagGuide);
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
                        System.out.println("You do not have such item");
                    }else {
                        Item item = player.getBackpack().getItem(index);
                        Thread.sleep(500);
                        player.getBackpack().useItem(item,player);
                        Thread.sleep(500);
                        System.out.println(player);
                        Thread.sleep(500);
                        player.getBackpack().displayItem();
                        System.out.println(bagGuide);
                    }

                }else {
                    System.out.println("Invalid input!");
                }

            }
            if(input.charAt(0)=='Q'){
                System.exit(0);
            }


            mapItemsList.set(stage-1,mapItems);

            if(stage==3 && location.equals(new Location(15,28)))
                win = true;
            return new Game(player,gameMaps,mapItemsList,stage,location,bagFlag,win);

        }


        /**
         * @param location
         * @param mapObject
         * @return boolean True if this location have event
         * @description whether this location have event
         * @author Zining He
        */

        public static boolean isEvent(Location location, HashMap<Location, MapItem> mapObject){
            List<Location> locations = new ArrayList<>(mapObject.keySet());
            return locations.contains(location);
        }


        /**
         * @param location player location
         * @param mapItems hashmap store items and monsters
         * @param player
         * @return boolean whether player goto next stage
         * @description eventTrigger, trigger event when player reach the location have exents
         * @author Zining He
        */

        public static boolean eventTrigger(Location location, HashMap<Location,MapItem> mapItems, Player player) throws InterruptedException {
            List<Location> locations = new ArrayList<>(mapItems.keySet());
            if(locations.contains(location)){


                if(mapItems.get(location) instanceof Gate){
                    if(((Gate) mapItems.get(location)).isLocked()){
                        Thread.sleep(500);
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
                    Thread.sleep(500);
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


        /**
         * @param args
         * @return void
         * @description main function will run the game
         * @author Zining He
         */
        public static void main(String[] args) throws InterruptedException {
            Scanner scanner = new Scanner(System.in);
            printGateGameTitle();
            String input = scanner.nextLine().toUpperCase();
            while (true){
                if(input.length()==1){
                    if(input.charAt(0)=='S'){
                        break;
                    }else if(input.charAt(0)=='Q'){
                        System.exit(0);
                    }
                }
            }
            System.out.println("In the magical kingdom of Eldoria");
            Thread.sleep(200);
            System.out.println("peace reigned until the day the evil sorcerer Malakar captured Princess Liora");
            Thread.sleep(200);
            System.out.println("the heart of the realm. With her disappearance, darkness has begun to creep across the land.");
            Thread.sleep(200);
            System.out.println("As a brave hero, it’s your mission to rescue the princess and restore light to Eldoria.");
            Thread.sleep(200);
            System.out.println("The hero finally arrived at the base of Malakar's castle, but he still needs to overcome three levels of challenges before he can face him.");

            GameEngine.getInstance().loadEngine();
            Game game = new Game();
            game.initGame();
            System.out.println(mapGuide);

            //for testing
            //game.getPlayer.getBackpack().addItem(Inventory.getInventory().createWeapon("Divine Rapier",350));

            int hp;
            boolean win;
            while (true) {
                game = gameLoop(game);
                hp = game.getPlayer().getHealth();
                win = game.win;
                if(hp<=0){
                    System.out.println("You dead!");
                    break;
                }
                if(win){
                    System.out.println("You win!");
                    Thread.sleep(500);
                    System.out.println("The hero passed through the three challenges and stood before him... To be continued.");
                    break;
                }
            }


        }
        /**
         * @param
         * @return void
         * @description To print game logo
         * @author Zining He
        */

        public static void printGateGameTitle() throws InterruptedException {
            String[] gateGameArt = {
                    " ######     ###    #######  #######    #####      ###    ##     ##  ####### ",
                    "##    ##   ## ##      ##    ##        ##    ##   ## ##   ###   ###  ##      ",
                    "##        ##   ##     ##    ##        ##        ##   ##  #### ####  ##      ",
                    "##   ###  #######     ##    ######    ##   ###  #######  ## ### ##  ######  ",
                    "##    ##  ##   ##     ##    ##        ##    ##  ##   ##  ##     ##  ##      ",
                    "##    ##  ##   ##     ##    ##        ##    ##  ##   ##  ##     ##  ##      ",
                    " ######   ##   ##     ##    #######    #####    ##   ##  ##     ##  #######  ",
                    "                                                                             ",
            };

            for (String line : gateGameArt) {
                System.out.println(line);
                Thread.sleep(200);
            }
            System.out.println("Input S to start");
            System.out.println("Input Q to Quit");
        }
    }
