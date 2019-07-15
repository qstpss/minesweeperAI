import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GameStartTest {
    @BeforeAll
    static void init() {
        Driver.INSTANCE.init();
    }

    @Test
    void startNewGameBeginner() {
        Driver.INSTANCE.startNewGame(GameDifficulty.BEGINNER);
    }
    @Test
    void startNewGameIntermediate() {
        Driver.INSTANCE.startNewGame(GameDifficulty.INTERMEDIATE);
    }
    @Test
    void startNewGameExpert() {
        Driver.INSTANCE.startNewGame(GameDifficulty.EXPERT);
    }

    @AfterAll
    static void release() {
        Driver.INSTANCE.getDriver().close();
    }
}
