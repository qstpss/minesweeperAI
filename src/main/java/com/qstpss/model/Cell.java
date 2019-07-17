package com.qstpss.model;

import java.util.Objects;

public class Cell {

    private State state;
    private Integer adjacentMinesCount;
    private int positionX;
    private int positionY;


    public Cell(State state, Integer adjacentMinesCount, int positionX, int positionY) {
        this.state = state;
        this.adjacentMinesCount = adjacentMinesCount;
        if (state != State.OPENED && adjacentMinesCount != null) {
            throw new IllegalStateException("In state " + state +
                    " cell doesn't contain defined number of mines = " + adjacentMinesCount);
        }
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getAdjacentMinesCount() {
        return adjacentMinesCount;
    }

    public void setAdjacentMinesCount(Integer adjacentMinesCount) {
        this.adjacentMinesCount = adjacentMinesCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return positionX == cell.positionX &&
                positionY == cell.positionY &&
                state == cell.state &&
                Objects.equals(adjacentMinesCount, cell.adjacentMinesCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(state, adjacentMinesCount, positionX, positionY);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "state=" + state +
                ", adjacentMinesCount=" + adjacentMinesCount +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}
