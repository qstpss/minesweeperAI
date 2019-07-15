import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public enum Driver {
    INSTANCE;

    private WebDriver driver;
    public static final String driverPath = "/home/mikhail/Documents/chromedriver";

    void init() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.driver = new ChromeDriver();
        driver.get("http://minesweeperonline.com");
    }

    void startNewGame(GameDifficulty difficulty) {
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
                throw new NotImplementedException();
                //todo add selecting a size amount of mines
        }
        gameDifficultyElement.click();
        WebElement startGameElement = driver.findElement(By.cssSelector("#options > tbody > tr:nth-child(7) > td:nth-child(1) > input"));
        startGameElement.click();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
