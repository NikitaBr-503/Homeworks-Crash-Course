import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class FirefoxDriver extends DriverManager {

    @Override
    public void startService() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Override
    public void createDriver() {
        driver =  new org.openqa.selenium.firefox.FirefoxDriver();
    }
}
