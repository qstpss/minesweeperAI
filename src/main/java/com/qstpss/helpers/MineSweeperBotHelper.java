package com.qstpss.helpers;

import com.qstpss.model.Cell;
import com.qstpss.model.GameField;
import com.qstpss.model.State;

import java.util.ArrayList;
import java.util.List;

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
}
