package com.example.gategame;

import com.example.gategame.backpack.Inventory;
import com.example.gategame.control.Location;
import com.example.gategame.items.gate.Enemy;
import com.example.gategame.items.gate.Gate;
import com.example.gategame.items.gate.GateKey;
import com.example.gategame.map.GameMap;
import com.example.gategame.map.MapItem;
import com.example.gategame.role.Player;
import com.example.gategame.role.RoleFactory;
import com.example.gategame.role.monster.Monster;
import com.example.gategame.role.monster.MonsterType;
import com.example.gategame.settings.LevelConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// sample game class for testing purpose, might need to modify later
public class Game {
    private Player player;
    private List<GameMap> gameMaps;
    private final List<HashMap<Location,MapItem>> mapItemsList;

    private int stage;
    public boolean bagFlag;

    public int getStage() {
        return stage;
    }

    private  Location playerLocation;
    boolean win = false;

    public Game(Player player, List<GameMap> gameMaps, List<HashMap<Location, MapItem>> mapItemsList, int stage, Location playerLocation,boolean bagFlag,boolean win) {
        this.player = player;
        this.gameMaps = gameMaps;
        this.mapItemsList = mapItemsList;
        this.stage = stage;
        this.playerLocation = playerLocation;
        this.bagFlag = bagFlag;
        this.win = win;
    }

    public Game() {
        gameMaps = new ArrayList<>();
        mapItemsList = new ArrayList<>();
        bagFlag = false;
    }

    public void initMapItems(){

        Random random = new Random();
        for (int i = 0; i < gameMaps.size(); i++) {
            List<Location> empty = gameMaps.get(i).getEmptyLocation();
            HashMap<Location,MapItem> mapItems = new HashMap<>();
            List<Monster> monsters = RoleFactory.createLevelMonsters();
            LevelConfig levelConfig = GameEngine.getInstance().getCurrentLevelConfig();

            Gate gate = new Gate(levelConfig.getGate().isLocked());
            Location gateLocation = gameMaps.get(i).getGateLocation();
            Location keyLocation = empty.get(random.nextInt(empty.size()));
            empty.remove(keyLocation);
            empty.remove(gateLocation);

            mapItems.put(gateLocation,gate);
            if (gate.isLocked()) {
                GateKey gateKey = new GateKey();
                mapItems.put(keyLocation,gateKey);
            }
            for (Monster monster:monsters){
                Location monsterLocation = empty.get(random.nextInt(empty.size()));
                mapItems.put(monsterLocation,monster);
                empty.remove(monsterLocation);
            }

            mapItemsList.add(mapItems);
            if(i<2){
                GameEngine.getInstance().gotoNextLevel();
            }
        }
    }



    public Location getPlayerLocation() {
        return playerLocation;
    }

    public void setGameMaps(List<GameMap> gameMaps) {
        this.gameMaps = gameMaps;
    }

//    public void setMapObjects(HashMap<Location, MapObject> mapObjects, int stage) {
//        this.mapObjects.set(stage-1,mapObjects);
//    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public void setPlayerLocation(Location playerLocation) {
        this.playerLocation = playerLocation;
    }

    public void initGame(){
        playerLocation = new Location(1,1);
        stage = 1;
        player = RoleFactory.createPlayer();
        player.getBackpack().addItem(Inventory.getInventory().createWeapon("Divine Rapier",350));
        // create Gate


        GameMap map1 = new GameMap(new String[]{
                "#################",
                "#..............##",
                "#.####.######..##",
                "#.#.........#.###",//1 room
                "#.#.####.####.###",
                "#...#...........#",
                "#################"
        });
        GameMap map2 = new GameMap(new String[]{
                "##############################",
                "#.................#.........##",
                "#..####.....#####.....#####..#",//3 room
                "#..#..#.....#...#.....#...#..#",
                "#..#..#.....#.........#...#..#",
                "#..#........#...#.....#......#",
                "#..####.....#####.....#####..#",
                "#.................#.........##",
                "###....##.................####",
                "#.................#.........##",
                "#..#####....#####..#######...#",//another 3 room
                "#..#............#..#.........#",
                "#..#####....#...#..#.....#...#",
                "#...........#...#..#.....#...#",
                "######......#####..#######...#",
                "#.................#..........#",
                "##############################"
        });
        GameMap map3 = new GameMap(new String[]{
                "##############################",
                "#..................#........##",
                "#..#####....#####..#.#######.#",
                "#......#....#......#.......#.#",
                "#..#####....#...#..#########.#",
                "#...........#...#........#.#.#",
                "######.#....#####..#####.#.#.#",
                "#..................#.....#...#",
                "######.................#######",
                "#.....#......................#",
                "#.#.###..###.###....##..#.####",
                "#.#...#..#.....#....#...#....#",
                "#.#...#..#.....#....#...######",
                "#.#...#..#######....#........#",
                "#.#####..........#..#######..#",
                "#........#........#..........#",
                "##############################"
        });

        gameMaps.add(map1);
        gameMaps.add(map2);
        gameMaps.add(map3);
        initMapItems();
//        gameMaps.get(0).setMapObjects(extractMapObjects().get(0));
        gameMaps.get(0).displayMap(playerLocation,mapItemsList.get(0));

    }

    /**
     * Init gate on map
     */
    private void createGate() {

    }


//    Inventory inventory = Inventory.getInventory();

//    public void initInventory(){
//        // add some sample items
//        inventory.createPotion("Small Healing Potion", 5);
//        inventory.createPotion("Medium Healing Potion", 10);
//        inventory.createPotion("Large Healing Potion", 20);
//        inventory.createWeapon("Small Sword", 3);
//        inventory.createWeapon("Long Sword", 5);
//        inventory.createWeapon("Big Sword", 10);
//        System.out.println(inventory);
//    }

    public Player getPlayer() {
        return player;
    }

    public List<GameMap> getGameMaps() {
        return gameMaps;
    }

    public List<HashMap<Location, MapItem>> getMapItemsList() {
        return mapItemsList;
    }

    public static void main(String[] args) {

//        // test sample usage
//        Game game = new Game();
////        Role player = new Player("player", " ", 10, 100);
//        game.initInventory();
//        Inventory inventory = Inventory.getInventory();
//        Backpack playerBackpack = new PlayerBackpack();
//        inventory.addItemToBackpack(playerBackpack, 0); // add a potion
//        playerBackpack.displayItem();
        GameEngine.getInstance().loadEngine();
        Game game = new Game();
        game.initGame();
        System.out.println(game.mapItemsList);
//        System.out.println(game.mapItemsList);
    }
}
