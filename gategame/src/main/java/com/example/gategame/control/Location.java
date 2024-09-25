package com.example.gategame.control;

import java.util.Objects;

public class Location {
    private int row;
    private int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    public Location moveW(){
        return new Location(this.row-1, this.col);
    }
    public Location moveA(){
        return new Location(this.row, this.col-1);
    }
    public Location moveS(){
        return new Location(this.row+1, this.col);
    }
    public Location moveD(){

        return new Location(this.row, this.col+1);
    }

    public String toString(){
        return col+" "+row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return getRow() == location.getRow() && getCol() == location.getCol();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRow(), getCol());
    }
}
