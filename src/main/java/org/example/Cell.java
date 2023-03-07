package org.example;

public class Cell {
    private int index;
    public String direction;
    public boolean rWall = true, bWall = true;

    public Cell(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
