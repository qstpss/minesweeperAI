package com.qstpss.model;

public class GameField {

    private int sizeX;
    private int sizeY;

    private int amountOfMines;
    private Cell[][] field;

    public GameField(int sizeX, int sizeY, int amountOfMines) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.amountOfMines = amountOfMines;
        this.field = new Cell[sizeY][sizeX];
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                this.field[y][x] = new Cell(State.CLOSED, null, x, y);
            }
        }
    }

    public Cell[][] getField() {
        return field;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getAmountOfMines() {
        return amountOfMines;
    }
}
