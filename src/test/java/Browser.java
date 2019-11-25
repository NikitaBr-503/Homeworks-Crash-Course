import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.DriverManager;

public class Browser {

    public static WebDriver getManager (String type) {

        WebDriver driver = null;

        if ("CHROME".equals(type)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("FIREFOX".equals(type)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
