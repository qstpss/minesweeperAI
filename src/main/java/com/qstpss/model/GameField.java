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
        this.field = new Cell[sizeX][sizeY];
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                this.field[i][j] = new Cell(State.CLOSED, null, j, i);
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
