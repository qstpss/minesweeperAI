package com.qstpss.ai;

import com.qstpss.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStartTest {

    private static WebDriver driver;
    private static MineSweeperBot bot;

    @BeforeAll
    static void init() {
        driver = Driver.INSTANCE.get();
        bot = new MineSweeperBot(driver);
    }

    @Test
    void startNewGameBeginnerTest() {
        bot.startNewGame(GameDifficulty.BEGINNER);
        int minesCount = bot.getMinesCountFromIndicator();
        assertEquals(10, minesCount);
    }
    @Test
    void startNewGameIntermediateTest() {
        bot.startNewGame(GameDifficulty.INTERMEDIATE);
        int minesCount = bot.getMinesCountFromIndicator();
        assertEquals(40, minesCount);
    }
    @Test
    void startNewGameExpertTest() {
        bot.startNewGame(GameDifficulty.EXPERT);
        int minesCount = bot.getMinesCountFromIndicator();
        assertEquals(99, minesCount);
    }

    @AfterAll
    static void close() {
        Driver.INSTANCE.release();
    }
}
