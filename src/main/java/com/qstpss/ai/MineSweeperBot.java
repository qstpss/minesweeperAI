package com.qstpss.ai;

import com.qstpss.helpers.MineSweeperBotHelper;
import com.qstpss.model.Cell;
import com.qstpss.model.GameField;
import com.qstpss.model.State;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;


public class MineSweeperBot {

    private WebDriver driver;
    private GameField gameField;
    private GameDifficulty difficulty;

    public MineSweeperBot(WebDriver driver) {
        this.driver = Objects.requireNonNull(driver);
    }

    public void startNewGame(GameDifficulty difficulty) {
        this.difficulty = difficulty;
        WebElement gameOptionsElement = driver.findElement(By.cssSelector("#options-link"));
        gameOptionsElement.click();
        WebElement gameDifficultyElement;
        int amountOfMines;
        int sizeX;
        int sizeY;
        switch (difficulty) {
            case BEGINNER:
                gameDifficultyElement = driver.findElement(By.cssSelector("#beginner"));
                amountOfMines = 10;
                sizeX = 9;
                sizeY = 9;
                break;
            case INTERMEDIATE:
                gameDifficultyElement = driver.findElement(By.cssSelector("#intermediate"));
                amountOfMines = 40;
                sizeX = 16;
                sizeY = 16;
                break;
            case EXPERT:
                amountOfMines = 99;
                sizeX = 30;
                sizeY = 16;
                gameDifficultyElement = driver.findElement(By.cssSelector("#expert"));
                break;
            default:
                gameDifficultyElement = driver.findElement(By.cssSelector("#custom"));
                throw new UnsupportedOperationException();
                //todo add selecting a size amount of mines
        }
        gameField = new GameField(sizeX, sizeY, amountOfMines);
        gameDifficultyElement.click();
        WebElement startGameElement =
                driver.findElement(By.cssSelector("#options > tbody > tr:nth-child(7) > td:nth-child(1) > input"));
        startGameElement.click();
    }

    //works very slow
    public void readToGameFieldObj() {
        Cell[][] field = gameField.getField();
        for (int y = 0; y < gameField.getSizeY(); y++) {
            for (int x = 0; x < gameField.getSizeX(); x++) {
                String cellId = String.valueOf(y + 1) + "_" + String.valueOf(x + 1);
                WebElement cellElement = driver.findElement(By.id(cellId));
                String cellClassValue = cellElement.getAttribute("class");
                Integer adjacentMinesCount = null;
                if (cellClassValue.contains("square open")) {
                    adjacentMinesCount = Integer.valueOf(
                            cellElement.getAttribute("class")
                                    .replaceAll("square open", ""));
                }
                State cellState;
                if (adjacentMinesCount != null) {
                    cellState = State.OPENED;
                } else {
                    if (cellClassValue.contains("square bombflagged")) {
                        cellState = State.MINED;
                    } else {
                        cellState = State.CLOSED;
                    }
                }
                field[y][x] = new Cell(cellState, adjacentMinesCount, x + 1, y + 1);
            }
        }
    }

    public void clickRandomCell() {
        List<Cell> closedCells = MineSweeperBotHelper.getClosedCells(gameField);
        Random random = new Random(System.currentTimeMillis());
        int rand = random.nextInt(closedCells.size());
        Cell randomCell = closedCells.get(rand);
        String cellId = randomCell.getPositionY() + "_" + randomCell.getPositionX();
        WebElement cellElement = driver.findElement(By.id(cellId));
        cellElement.click();
    }

    public int getMinesCountFromIndicator() {
        WebElement minesHundredsIndicator = driver.findElement(By.cssSelector("#mines_hundreds"));
        WebElement minesTensIndicator = driver.findElement(By.cssSelector("#mines_tens"));
        WebElement minesOnesIndicator = driver.findElement(By.cssSelector("#mines_ones"));

        String minesHundredsClass = minesHundredsIndicator.getAttribute("class");
        String minesTensClass = minesTensIndicator.getAttribute("class");
        String minesOnesClass = minesOnesIndicator.getAttribute("class");

        String minesCountAsString = minesHundredsClass.replaceAll("time", "") +
                minesTensClass.replaceAll("time", "") +
                minesOnesClass.replaceAll("time", "");

        return Integer.parseInt(minesCountAsString);
    }

    public GameField getGameField() {
        return gameField;
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;//todo it is needed for test purpose only! decide what to do with this
    }
}
