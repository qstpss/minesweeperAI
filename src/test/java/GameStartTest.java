import ai.GameDifficulty;
import ai.MineSweeperBot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameStartTest {

    private static MineSweeperBot bot;

    @BeforeAll
    static void init() {
        WebDriver driver = Driver.INSTANCE.get();
        bot = new MineSweeperBot(driver);
    }

    @Test
    void startNewGameBeginner() {
        bot.startNewGame(GameDifficulty.BEGINNER);
        int minesCount = bot.getMinesCountFromIndicator();
        assertEquals(10, minesCount);
    }
    @Test
    void startNewGameIntermediate() {
        bot.startNewGame(GameDifficulty.INTERMEDIATE);
        int minesCount = bot.getMinesCountFromIndicator();
        assertEquals(40, minesCount);
    }
    @Test
    void startNewGameExpert() {
        bot.startNewGame(GameDifficulty.EXPERT);
        int minesCount = bot.getMinesCountFromIndicator();
        assertEquals(99, minesCount);
    }

    @AfterAll
    static void close() {
        Driver.INSTANCE.release();
    }
}
