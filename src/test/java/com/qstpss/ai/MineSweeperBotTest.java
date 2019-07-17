package com.qstpss.ai;

import com.qstpss.Driver;
import com.qstpss.model.Cell;
import com.qstpss.model.GameField;
import com.qstpss.model.State;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MineSweeperBotTest {

    private static WebDriver driver;
    private static MineSweeperBot bot;

    @BeforeAll
    static void init() {
        driver = Driver.INSTANCE.get();
        bot = new MineSweeperBot(driver);
    }

    @Test
    void startNewGameBeginnerTest() {
        driver.get("http://minesweeperonline.com");
        bot.startNewGame(GameDifficulty.BEGINNER);
        int minesCount = bot.getMinesCountFromIndicator();
        assertEquals(10, minesCount);
    }
    @Test
    void startNewGameIntermediateTest() {
        driver.get("http://minesweeperonline.com");
        bot.startNewGame(GameDifficulty.INTERMEDIATE);
        int minesCount = bot.getMinesCountFromIndicator();
        assertEquals(40, minesCount);
    }
    @Test
    void startNewGameExpertTest() {
        driver.get("http://minesweeperonline.com");
        bot.startNewGame(GameDifficulty.EXPERT);
        int minesCount = bot.getMinesCountFromIndicator();
        assertEquals(99, minesCount);
    }

    @Test
    void readToGameFieldObjTest() {
        File testHtmlPage = new File("src/test/resources/readBeginner.html");
        driver.get("file:///" + testHtmlPage.getAbsolutePath());
        GameField beginnerField = new GameField(9, 9, 10);
        bot.setGameField(beginnerField);
        bot.readToGameFieldObj();
        Cell[][] actualField = bot.getGameField().getField();
        List<Cell> expectedCells = getExpectedCells();
        expectedCells.forEach(cell ->
                assertEquals(cell,
                        actualField[cell.getPositionY() - 1][cell.getPositionX() - 1]));

    }

    private List<Cell> getExpectedCells() {
        return new ArrayList<>(){{
            add(new Cell(State.OPENED, 0, 1, 1));
            add(new Cell(State.OPENED, 1, 2, 1));
            add(new Cell(State.OPENED, 1, 3, 1));
            add(new Cell(State.CLOSED, null, 4, 1));
            add(new Cell(State.CLOSED, null, 5, 1));
            add(new Cell(State.CLOSED, null, 6, 1));
            add(new Cell(State.CLOSED, null, 7, 1));
            add(new Cell(State.CLOSED, null, 8, 1));
            add(new Cell(State.CLOSED, null, 9, 1));
            add(new Cell(State.OPENED, 0, 1, 2));
            add(new Cell(State.OPENED, 1, 2, 2));
            add(new Cell(State.MINED, null, 3, 2));
            add(new Cell(State.CLOSED, null, 4, 2));
            add(new Cell(State.CLOSED, null, 5, 2));
            add(new Cell(State.CLOSED, null, 6, 2));
            add(new Cell(State.CLOSED, null, 7, 2));
            add(new Cell(State.CLOSED, null, 8, 2));
            add(new Cell(State.CLOSED, null, 9, 2));
            add(new Cell(State.OPENED, 0, 1, 3));
            add(new Cell(State.OPENED, 1, 2, 3));
            add(new Cell(State.OPENED, 1, 3, 3));
            add(new Cell(State.OPENED, 2, 4, 3));
            add(new Cell(State.OPENED, 2, 5, 3));
            add(new Cell(State.OPENED, 2, 6, 3));
            add(new Cell(State.OPENED, 2, 7, 3));
            add(new Cell(State.CLOSED, null, 8, 3));
            add(new Cell(State.CLOSED, null, 9, 3));
            add(new Cell(State.OPENED, 0, 1, 4));
            add(new Cell(State.OPENED, 0, 2, 4));
            add(new Cell(State.OPENED, 0, 3, 4));
            add(new Cell(State.OPENED, 1, 4, 4));
            add(new Cell(State.MINED, null, 5, 4));
            add(new Cell(State.OPENED, 1, 6, 4));
            add(new Cell(State.OPENED, 1, 7, 4));
            add(new Cell(State.CLOSED, null, 8, 4));
            add(new Cell(State.CLOSED, null, 9, 4));
            add(new Cell(State.OPENED, 0, 1, 5));
            add(new Cell(State.OPENED, 0, 2, 5));
            add(new Cell(State.OPENED, 0, 3, 5));
            add(new Cell(State.OPENED, 1, 4, 5));
            add(new Cell(State.OPENED, 1, 5, 5));
            add(new Cell(State.OPENED, 1, 6, 5));
            add(new Cell(State.OPENED, 2, 7, 5));
            add(new Cell(State.CLOSED, null, 8, 5));
            add(new Cell(State.CLOSED, null, 9, 5));
            add(new Cell(State.OPENED, 1, 1, 6));
            add(new Cell(State.OPENED, 1, 2, 6));
            add(new Cell(State.OPENED, 0, 3, 6));
            add(new Cell(State.OPENED, 0, 4, 6));
            add(new Cell(State.OPENED, 0, 5, 6));
            add(new Cell(State.OPENED, 0, 6, 6));
            add(new Cell(State.OPENED, 1, 7, 6));
            add(new Cell(State.CLOSED, null, 8, 6));
            add(new Cell(State.CLOSED, null, 9, 6));
            add(new Cell(State.MINED, null, 1, 7));
            add(new Cell(State.OPENED, 1, 2, 7));
            add(new Cell(State.OPENED, 0, 3, 7));
            add(new Cell(State.OPENED, 0, 4, 7));
            add(new Cell(State.OPENED, 1, 5, 7));
            add(new Cell(State.OPENED, 1, 6, 7));
            add(new Cell(State.OPENED, 2, 7, 7));
            add(new Cell(State.CLOSED, null, 8, 7));
            add(new Cell(State.CLOSED, null, 9, 7));
            add(new Cell(State.OPENED, 1, 1, 8));
            add(new Cell(State.OPENED, 1, 2, 8));
            add(new Cell(State.OPENED, 0, 3, 8));
            add(new Cell(State.OPENED, 0, 4, 8));
            add(new Cell(State.OPENED, 1, 5, 8));
            add(new Cell(State.MINED, null, 6, 8));
            add(new Cell(State.OPENED, 2, 7, 8));
            add(new Cell(State.CLOSED, null, 8, 8));
            add(new Cell(State.CLOSED, null, 9, 8));
            add(new Cell(State.OPENED, 0, 1, 9));
            add(new Cell(State.OPENED, 0, 2, 9));
            add(new Cell(State.OPENED, 0, 3, 9));
            add(new Cell(State.OPENED, 0, 4, 9));
            add(new Cell(State.OPENED, 1, 5, 9));
            add(new Cell(State.CLOSED, null, 6, 9));
            add(new Cell(State.CLOSED, null, 7, 9));
            add(new Cell(State.CLOSED, null, 8, 9));
            add(new Cell(State.CLOSED, null, 9, 9));
        }};
    }

    @AfterAll
    static void close() {
        Driver.INSTANCE.release();
    }
}
