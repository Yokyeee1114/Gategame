package com.example.gategame.map;

public class HealPackTest implements MapObject{
    private int row, col;
    public HealPackTest(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public char getSymbol() { return '+'; }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
