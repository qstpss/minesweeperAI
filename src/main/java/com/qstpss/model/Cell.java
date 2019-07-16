package com.qstpss.model;

import java.util.Objects;

public class Cell {

    private State state;
    private Integer adjacentMinesCount;
    private int coordinateX;
    private int coordinateY;

    public Cell(State state, Integer adjacentMinesCount, int coordinateX, int coordinateY) {
        this.state = state;
        this.adjacentMinesCount = adjacentMinesCount;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
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

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return coordinateX == cell.coordinateX &&
                coordinateY == cell.coordinateY &&
                state == cell.state &&
                Objects.equals(adjacentMinesCount, cell.adjacentMinesCount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(state, adjacentMinesCount, coordinateX, coordinateY);
    }
}
