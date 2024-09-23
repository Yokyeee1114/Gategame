package com.example.gategame.map;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private char[][] grid;
    private int rows;
    private int cols;
    private int doorRow;
    private int doorCol;
    private List<MapObject> mapObjects;

    public GameMap(String[] mapData) {
        this.rows = mapData.length;
        this.cols = mapData[0].length();
        this.grid = new char[rows][cols];
        this.mapObjects = new ArrayList<>();

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
    public void addMapObject(MapObject obj) {
        mapObjects.add(obj);
    }

    /**
     *
     * @param playerRow
     * @param playerCol
     */
    public void displayMap(int playerRow, int playerCol) {
        char[][] displayGrid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            displayGrid[i] = grid[i].clone();
        }

        // add the map Object
        for (MapObject obj : mapObjects) {
            displayGrid[obj.getRow()][obj.getCol()] = obj.getSymbol();
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
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && (grid[row][col] == '.' || grid[row][col] == 'D');
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public boolean isDoor(int row, int col) {
        return row == doorRow && col == doorCol;
    }

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public MapObject getObjectAt(int row, int col) {
        for (MapObject obj : mapObjects) {
            if (obj.getRow() == row && obj.getCol() == col) {
                return obj;
            }
        }
        return null;
    }

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
