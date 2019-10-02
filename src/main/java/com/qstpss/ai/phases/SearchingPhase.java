package com.qstpss.ai.phases;

import com.qstpss.ai.MineSweeperBot;
import com.qstpss.helpers.MineSweeperBotHelper;
import com.qstpss.model.Cell;
import com.qstpss.model.GameField;
import com.qstpss.model.State;

import java.util.List;

import static com.qstpss.helpers.MineSweeperBotHelper.*;

public class SearchingPhase extends Phase {

    private SearchingPhase() {

    }

    public SearchingPhase(MineSweeperBot mineSweeperBot) {
        this.mineSweeperBot = mineSweeperBot;
    }

    @Override
    public void doJob() {
        GameField gameField = mineSweeperBot.getGameField();
        Cell[][] cells = gameField.getField();
        outer:
        for (int y = 0; y < gameField.getSizeY(); y++) {
            for (int x = 0; x < gameField.getSizeX(); x++) {
                Cell cell = cells[y][x];
                if (cell.getState() == State.CLOSED || cell.getState() == State.MINED) {
                    continue;
                }
                int closedCells = getAmountOfAdjacentClosedCells(gameField, cell);
                if (closedCells == 1) {
                    cell.setState(State.MINED);
                    break outer;
                }
                List<Cell> closedAndMinedCells = getAdjacentClosedAndMinedCells(gameField, cell);
                if (cell.getAdjacentMinesCount() >= closedAndMinedCells.size()) {
                    closedAndMinedCells.stream()
                            .filter(cell1 -> cell1.getState() == State.CLOSED)
                            .forEach(cell1 ->
                                    cells[cell1.getPositionY() - 1][cell1.getPositionX() - 1]
                                            .setState(State.MINED));
                    break outer;
                }
            }
        }
    }
}
