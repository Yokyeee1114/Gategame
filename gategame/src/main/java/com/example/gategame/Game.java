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
            List<Location> empty = gameMaps.get(0).getEmptyLocation();
            HashMap<Location,MapItem> mapItems = new HashMap<>();
//            Random random = new Random();
//
//            int index = random.nextInt(empty.size());
//            Location location = empty.get(index);
//            empty.remove(location);
            Location location = new Location(3,1);
//            Monster monster = RoleFactory.createMonster(MonsterType.MINOR);
        MapItem potion = Inventory.getInventory().createPotion("Small Potion", 10);


        Location location2 = new Location(1,3);
        Monster monster2 = RoleFactory.createMonster(MonsterType.ELITE);
        Enemy enemy2 = new Enemy(monster2);

        mapItems.put(location2, enemy2);

        LevelConfig levelConfig = GameEngine.getInstance().getCurrentLevelConfig();
        Gate gate = new Gate(levelConfig.getGate().isLocked());
        mapItems.put(new Location(5,2),gate);
        if (gate.isLocked()) {
            GateKey gateKey = new GateKey();
            mapItems.put(new Location(4,1),gateKey);
        }

        mapItemsList.add(mapItems);

        GameEngine.getInstance().gotoNextLevel();

        HashMap<Location,MapItem> mapItems2 = new HashMap<>();
        mapItems2.put(new Location(1,8),RoleFactory.createMonster(MonsterType.BOSS));
        LevelConfig levelConfig2 = GameEngine.getInstance().getCurrentLevelConfig();
        Gate gate2 = new Gate(levelConfig2.getGate().isLocked());
        mapItems2.put(new Location(5,2),gate2);
        if (gate2.isLocked()) {
            GateKey gateKey2 = new GateKey();
            mapItems2.put(new Location(4,1),gateKey2);
        }
        mapItemsList.add(mapItems2);

        GameEngine.getInstance().gotoNextLevel();

        HashMap<Location,MapItem> mapItems3 = new HashMap<>();
        mapItems3.put(new Location(1,8),RoleFactory.createMonster(MonsterType.BOSS));
        LevelConfig levelConfig3 = GameEngine.getInstance().getCurrentLevelConfig();
        Gate gate3 = new Gate(levelConfig3.getGate().isLocked());
        mapItems3.put(new Location(5,2),gate3);
        if (gate3.isLocked()) {
            GateKey gateKey3 = new GateKey();
            mapItems3.put(new Location(4,1),gateKey3);
        }
        mapItemsList.add(mapItems3);
//        GameEngine.getInstance().setCurrentLevel(0);

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
        player.getBackpack().addItem(Inventory.getInventory().createWeapon("Holy sword",200));
        // create Gate


        GameMap map1 = new GameMap(new String[]{
                "#################",
                "#..............##",
                "#.####.######..##",
                "#.#.........#.###",//1 room
                "#.#.#########.###",
                "#...#.....#...###",
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
                "#.................#.........##",
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
                "#........#........#.........W#",
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
