package ai;

import model.GameField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Objects;


public class MineSweeperBot {

    private WebDriver driver;
    private GameField gameField;

    public MineSweeperBot(WebDriver driver) {
        this.driver = Objects.requireNonNull(driver);
    }

    public void startNewGame(GameDifficulty difficulty) {
        WebElement gameOptionsElement = driver.findElement(By.cssSelector("#options-link"));
        gameOptionsElement.click();
        WebElement gameDifficultyElement = null;
        switch (difficulty) {
            case BEGINNER:
                gameDifficultyElement = driver.findElement(By.cssSelector("#beginner"));
                break;
            case INTERMEDIATE:
                gameDifficultyElement = driver.findElement(By.cssSelector("#intermediate"));
                break;
            case EXPERT:
                gameDifficultyElement = driver.findElement(By.cssSelector("#expert"));
                break;
            case SPECIAL:
                gameDifficultyElement = driver.findElement(By.cssSelector("#custom"));
                throw new UnsupportedOperationException();
                //todo add selecting a size amount of mines
        }
        gameDifficultyElement.click();
        WebElement startGameElement = driver.findElement(By.cssSelector("#options > tbody > tr:nth-child(7) > td:nth-child(1) > input"));
        startGameElement.click();
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
        this.gameField = gameField;
    }
}
