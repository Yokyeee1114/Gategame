package com.example.gategame.map;

public class GameMap {
    private char[][] grid;
    private int rows;
    private int cols;
    private int doorRow;
    private int doorCol;

    public GameMap(String[] mapData) {
        this.rows = mapData.length;
        this.cols = mapData[0].length();
        this.grid = new char[rows][cols];

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

    /**
     *
     * @param playerRow
     * @param playerCol
     */
    public void displayMap(int playerRow, int playerCol) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == playerRow && j == playerCol) {
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
     * @param row
     * @param col
     * @return
     */
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && (grid[row][col] == '.' || grid[row][col] == 'D');
    }
    public boolean isDoor(int row, int col) {
        return row == doorRow && col == doorCol;
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
