package com.qstpss.helpers;

import com.qstpss.model.Cell;
import com.qstpss.model.GameField;
import com.qstpss.model.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MineSweeperBotHelper {

    public static List<Cell> getClosedCells(GameField gameField) {
        Cell[][] field = gameField.getField();
        List<Cell> closedCells = new ArrayList<>();
        for (int y = 0; y < gameField.getSizeY(); y++) {
            for (int x = 0; x < gameField.getSizeX(); x++) {
                Cell cell = field[y][x];
                if (cell.getState() == State.CLOSED) {
                    closedCells.add(cell);
                }
            }
        }
        return closedCells;
    }

    public static int getAmountOfAdjacentOpenedCells(GameField gameField, Cell targetCell) {
        throw new UnsupportedOperationException();
    }

    public static List<Cell> getAdjacentClosedCells(GameField gameField, Cell targetCell) {
        Cell[][] field = gameField.getField();
        return Arrays.stream(field).flatMap(Arrays::stream)
                .filter(
                        cell -> (cell.getState() == State.CLOSED) &&
                        isAdjacentCell(targetCell, cell)
                ).collect(Collectors.toList());
    }

    private static boolean isAdjacentCell(Cell targetCell, Cell checkedCell) {
        return ((checkedCell.getPositionY() == targetCell.getPositionY()) ||
                (checkedCell.getPositionY() == targetCell.getPositionY() + 1) ||
                (checkedCell.getPositionY() == targetCell.getPositionY() - 1))
                &&
                ((checkedCell.getPositionX() == targetCell.getPositionX()) ||
                (checkedCell.getPositionX() == targetCell.getPositionX() + 1) ||
                (checkedCell.getPositionX() == targetCell.getPositionX() - 1));
    }

}
