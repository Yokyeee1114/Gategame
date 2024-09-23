package com.example.gategame.map;

public class EnemyTest implements MapObject{
    private int row, col;
    public EnemyTest(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public char getSymbol() { return 'E'; }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
