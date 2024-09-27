package com.example.gategame.map;

import com.example.gategame.control.Location;
import com.example.gategame.items.gate.Enemy;
import com.example.gategame.items.gate.Gate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameMap {
    private char[][] grid;
    private int rows;
    private int cols;
    private int doorRow;
    private int doorCol;
//    private List<MapObject> mapObjects;

    private List<MapItem> mapItems;

    // generate map with items
    public GameMap(List<MapItem> mapItems) {
        this.mapItems = mapItems;
    }



    /**
     * @ author Yuheng Li
     * @ param mapData
     */
    public GameMap(String[] mapData) {
        this.rows = mapData.length;
        this.cols = mapData[0].length();
        this.grid = new char[rows][cols];
//        this.mapObjects = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = mapData[i].charAt(j);
                if (grid[i][j] == 'D') {
                    doorRow = i;
                    doorCol = j;
                }
            }
        }
    }
//    public void addMapObject(MapObject obj) {
//        mapObjects.add(obj);
//    }
//    public void removeMapObject(MapObject obj) {
//        mapObjects.remove(obj);
//    }
//
//    public List<MapObject> getMapObjects() {
//        return mapObjects;
//    }
//
//    public void setMapObjects(List<MapObject> mapObjects) {
//        this.mapObjects = mapObjects;
//    }

    public List<Location> getEmptyLocation(){
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <cols ; j++) {
                if(grid[i][j]=='.'){
                    locations.add(new Location(i,j));
                }
            }
        }
        locations.remove(new Location(1,1));
        return locations;
    }

    public void displayMap(Location location,HashMap<Location,MapItem> mapItems) {
        int playerRow = location.getRow();
        int playerCol = location.getCol();
        char[][] displayGrid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            displayGrid[i] = grid[i].clone();
        }

        // add the map Object
//        for (MapObject obj : mapObjects) {
//            displayGrid[obj.getRow()][obj.getCol()] = obj.getSymbol();
//        }
        List<Location> locations = new ArrayList<>(mapItems.keySet());
        for (Location itemlocation :locations) {
            displayGrid[itemlocation.getRow()][itemlocation.getCol()] = mapItems.get(itemlocation).getSymbol();
        }

        // add the player
        displayGrid[playerRow][playerCol] = 'P';


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(displayGrid[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * @author Yuheng Li
     * @param playerRow
     * @param playerCol
     */
    public void displayMap(int playerRow, int playerCol) {
        char[][] displayGrid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            displayGrid[i] = grid[i].clone();
        }

//        // add the map Object
//        for (MapObject obj : mapObjects) {
//            displayGrid[obj.getRow()][obj.getCol()] = obj.getSymbol();
//        }

        // add the player
        displayGrid[playerRow][playerCol] = 'P';


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(displayGrid[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * @author Yuheng Li
     * @param row
     * @param col
     * @return
     */
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && (grid[row][col] == '.' || grid[row][col] == 'D');
    }
    public boolean isValidMove(Location location) {
        int row = location.getRow();
        int col = location.getCol();
        return row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] != '#';
    }



    /**
     * @author Yuheng Li
     * @param row
     * @param col
     * @return
     */
    public boolean isDoor(int row, int col) {
        return row == doorRow && col == doorCol;
    }

//    /**
//     * @author Yuheng Li
//     * @param row
//     * @param col
//     * @return
//     */
//    public MapObject getObjectAt(int row, int col) {
//        for (MapObject obj : mapObjects) {
//            if (obj.getRow() == row && obj.getCol() == col) {
//                return obj;
//            }
//        }
//        return null;
//    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
