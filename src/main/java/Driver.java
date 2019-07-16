import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public enum Driver {
    INSTANCE;

    private WebDriver driver;
    public static final String driverPath = "/home/mikhail/Documents/chromedriver";

    {
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.driver = new ChromeDriver();
        driver.get("http://minesweeperonline.com");
    }

    public WebDriver get() {
        return driver;
    }

    public void release() {
        if (driver != null) {
            driver.close();
        }
    }
}
