package com.example.gategame.map;

public class WeaponTest implements MapObject{
    private int row, col;
    public WeaponTest(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public char getSymbol() { return 'W'; }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
