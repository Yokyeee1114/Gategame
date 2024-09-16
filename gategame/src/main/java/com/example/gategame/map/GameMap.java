package com.example.gategame.map;

import com.example.gategame.control.Location;

public class GameMap {
    private char[][] grid;
    private int rows;
    private int cols;

    public GameMap(String[] mapData) {
        this.rows = mapData.length;
        this.cols = mapData[0].length();
        this.grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = mapData[i].charAt(j);
            }
        }
    }

    /**
     *
     * @param playerLocation
     */
    public void displayMap(Location playerLocation) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == playerLocation.getRow() && j == playerLocation.getCol()) {
                    System.out.print('P');
                } else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }
    }

    /**
     *
     * @param
     * @return
     */
    public  boolean isValidMove(Location playerLocation) {
        return playerLocation.getRow() >= 0 && playerLocation.getRow() < rows && playerLocation.getCol() >= 0 && playerLocation.getCol()
                < cols && grid[playerLocation.getRow()][playerLocation.getCol()] == '.';
    }

    public char getTarget(Location location){
        return this.grid[location.getRow()][location.getCol()];
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
