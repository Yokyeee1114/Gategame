package com.example.gategame;

import com.example.gategame.backpack.Inventory;
import com.example.gategame.control.Location;
import com.example.gategame.map.Enemy;
import com.example.gategame.map.GameMap;
import com.example.gategame.map.MapItem;
import com.example.gategame.map.MapObject;
import com.example.gategame.role.Monster;
import com.example.gategame.role.MonsterType;
import com.example.gategame.role.Player;
import com.example.gategame.role.RoleFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// sample game class for testing purpose, might need to modify later
public class Game {
    private Player player;
    private List<GameMap> gameMaps;
    private List<HashMap<Location,MapObject>> mapObjects;

    private int stage;

    public int getStage() {
        return stage;
    }

    private  Location playerLocation;

    public Game(Player player, List<GameMap> gameMaps, List<HashMap<Location, MapObject>> mapObjects, int stage, Location playerLocation) {
        this.player = player;
        this.gameMaps = gameMaps;
        this.mapObjects = mapObjects;
        this.stage = stage;
        this.playerLocation = playerLocation;
    }

    public Game() {
        gameMaps = new ArrayList<>();
        mapObjects = new ArrayList<>();
    }

    public void initMapObjects(){
            List<Location> empty = gameMaps.get(0).getEmptyLocation();
            HashMap<Location,MapObject> objects = new HashMap<>();
//            Random random = new Random();
//
//            int index = random.nextInt(empty.size());
//            Location location = empty.get(index);
//            empty.remove(location);
            Location location = new Location(3,1);
//            Monster monster = RoleFactory.createMonster(MonsterType.MINOR);
        MapItem potion = Inventory.getInventory().createPotion("Small Potion", 10);
            Enemy enemy1 = new Enemy(location);
        enemy1.setMapItem(potion);
        objects.put(location, enemy1);

        Location location2 = new Location(1,3);
        Monster monster2 = RoleFactory.createMonster(MonsterType.ELITE);
        Enemy enemy2 = new Enemy(location2);
        enemy2.setMapItem(monster2);

        objects.put(location2, enemy2);

        mapObjects.add(objects);
    }

    public  List<List<MapObject>> extractMapObjects() {
        List<List<MapObject>> objectList = new ArrayList<>();

        for (HashMap<Location, MapObject> map : mapObjects) {
            List<MapObject> row = new ArrayList<>(map.values());
            objectList.add(row);
        }
        return objectList;
    }

    public Location getPlayerLocation() {
        return playerLocation;
    }

    public void setGameMaps(List<GameMap> gameMaps) {
        this.gameMaps = gameMaps;
    }

    public void setMapObjects(HashMap<Location, MapObject> mapObjects, int stage) {
        this.mapObjects.set(stage-1,mapObjects);
    }

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
        GameMap map1 = new GameMap(new String[]{
                "########D########",
                "#..............##",
                "#.####.#####.#.##",
                "#.#.........#.###",
                "#.#.#######.#.###",
                "#...#.....#...###",
                "#################"
        });

        gameMaps.add(map1);
        initMapObjects();
        gameMaps.get(0).setMapObjects(extractMapObjects().get(0));
        gameMaps.get(0).displayMap(1,1);
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

    public List<HashMap<Location, MapObject>> getMapObjects() {
        return mapObjects;
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

        Game game = new Game();
        game.initGame();
    }
}
