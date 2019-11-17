package BrowsersManager;

import io.github.bonigarcia.wdm.WebDriverManager;

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

