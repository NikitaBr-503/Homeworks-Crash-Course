package Tests;

import BrowsersManager.DriverTypes;
import BrowsersManager.DriverManager;
import BrowsersManager.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainTests extends PageObject {
    DriverManager driverManager;
    WebDriver driver;

    //ClassName locator of search field

    @Parameters("driver-name")
    @BeforeTest
    public void beforeTest(String type) {
        driverManager = DriverManagerFactory.getManager(DriverTypes.valueOf(type));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void Test()  {
        //open google
        driver.get(GoogleLink);
        //searching
        driver.findElement(By.name(searchField)).sendKeys(InputMessage);
        driver.findElement(By.name(searchField)).sendKeys(Keys.ENTER);
        //waiting
        TimeWaiter.Waiting(driver, searchLink);
        //check name of link
        String ActualNameOfFirstLink = driver.findElement(By.className(searchLink)).getText();
        Assert.assertEquals(ActualNameOfFirstLink,  ExpectedNameOfFirstLink);
        //open page
        driver.findElement(By.className(searchLink)).click();
        //waiting for open page
        TimeWaiter.Waiting(driver, headerOfPage);
        //check url
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,  ExpectedSoftServeUrl);
    }
}
