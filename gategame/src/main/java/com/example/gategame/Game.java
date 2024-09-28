package com.example.gategame;

import com.example.gategame.backpack.Inventory;
import com.example.gategame.Move.Location;
import com.example.gategame.items.gate.Gate;
import com.example.gategame.items.gate.GateKey;
import com.example.gategame.map.GameMap;
import com.example.gategame.map.MapItem;
import com.example.gategame.role.Player;
import com.example.gategame.role.RoleFactory;
import com.example.gategame.role.monster.Monster;
import com.example.gategame.settings.LevelConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author Zining He
 * Game class to store all information in a game
 */
public class Game {
    private Player player;
    private List<GameMap> gameMaps;//store game maps
    private final List<HashMap<Location,MapItem>> mapItemsList; //store items and monsters on each map
    private int stage; // current level
    public boolean bagFlag;    //flag that player open the backpack or not
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

    /**
     * @param
     * @return void
     * @description initMapItems, read the json and randomly generate monsters and keys and put them on the map
     * @author Zining He
    */

    public void initMapItems(){

        Random random = new Random();
        for (int i = 0; i < gameMaps.size(); i++) {
            List<Location> empty = gameMaps.get(i).getEmptyLocation();
            HashMap<Location,MapItem> mapItems = new HashMap<>();

            //load config
            List<Monster> monsters = RoleFactory.createLevelMonsters();
            LevelConfig levelConfig = GameEngine.getInstance().getCurrentLevelConfig();

            //create gate and key
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

            //create monsters
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





    /**
     * @param 
     * @return void
     * @description Initialize the game
     * @author Zining He
    */
    
    public void initGame(){
        //create player location
        playerLocation = new Location(1,1);
        stage = 1;
        player = RoleFactory.createPlayer();
        //create 3 maps
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
        //put item and monster on map
        initMapItems();
        gameMaps.get(0).displayMap(playerLocation,mapItemsList.get(0));

    }
    
    public Location getPlayerLocation() {
        return playerLocation;
    }

    public int getStage() {
        return stage;
    }
    public Player getPlayer() {
        return player;
    }

    public List<GameMap> getGameMaps() {
        return gameMaps;
    }

    public List<HashMap<Location, MapItem>> getMapItemsList() {
        return mapItemsList;
    }


}
