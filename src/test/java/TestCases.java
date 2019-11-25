import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestCases extends PageObject{

    private WebDriver driver;

    @Parameters("driver-name")
    @BeforeTest
    public void beforeTest(String type) {
        driver = Browser.getManager(type);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @DataProvider(name = "Github")
    public static Object[] Github() {
        return new Object[]  {"Github"};
    }
    @DataProvider(name = "Wikipedia")
    public static Object[] Wikipedia() {
        return new Object[]  { "Wikipedia"};
    }
    @Test(dataProvider = "Github")
    public void TestGithub(String Github){
        driver.get(GoogleLink);
        driver.findElement(By.name(searchField)).sendKeys(Github);
        driver.findElement(By.name(searchField)).sendKeys(Keys.ENTER);
        String actualResultGit = driver.findElement(By.className(ResultLocatorGit)).getText();
        Assert.assertEquals(actualResultGit, expectedResultGit);
    }

    @Test(dataProvider = "Wikipedia")
    public void TestWikipedia(String Wikipedia){
        driver.get(GoogleLink);
        driver.findElement(By.name(searchField)).sendKeys(Wikipedia);
        driver.findElement(By.name(searchField)).sendKeys(Keys.ENTER);
        String actualResultWiki = driver.findElement(By.xpath(ResultLocatorWiki)).getText();
        Assert.assertEquals(actualResultWiki, expectedResultWiki);
    }

}
