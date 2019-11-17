package BrowsersManager;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ChromeDriver extends DriverManager {
    @Override
    public void startService() {
        WebDriverManager.chromedriver().setup();
    }

    @Override
    public void createDriver() {
        driver = new org.openqa.selenium.chrome.ChromeDriver();
    }

}