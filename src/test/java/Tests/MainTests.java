package Tests;

import BrowsersManager.DriverTypes;
import BrowsersManager.DriverManager;
import BrowsersManager.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainTests {
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
        driver.get(LocatorsOfPage.GoogleLink);
        //searching
        driver.findElement(By.name("q")).sendKeys(LocatorsOfPage.InputMessage);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //waiting
        TimeWaiter.Waiting(driver, LocatorsOfPage.searchLink);
        //check name of link
        String ActualNameOfFirstLink = driver.findElement(By.className(LocatorsOfPage.searchLink)).getText();
        Assert.assertEquals(ActualNameOfFirstLink,  LocatorsOfPage.ExpectedNameOfFirstLink);
        //open page
        driver.findElement(By.className(LocatorsOfPage.searchLink)).click();
        //waiting for open page
        TimeWaiter.Waiting(driver, LocatorsOfPage.headerOfPage);
        //check url
        String ActualUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActualUrl,  LocatorsOfPage.ExpectedSoftServeUrl);
    }
}
