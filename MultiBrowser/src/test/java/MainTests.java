import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainTests {
    DriverManager driverManager;
    WebDriver driver;

    //ClassName locator of search field
    private String searchField = "LC20lb";

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
        driver.get("https://www.google.com");

        //searching
        driver.findElement(By.name("q")).sendKeys("softserve it academy");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //waiting
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(searchField)));

        //check name of link
        String nameOfFirstLink = driver.findElement(By.className(searchField)).getText();
        Assert.assertEquals(nameOfFirstLink,  "Школа програмування : SoftServe провідна IT-компанія");

        //open page
        driver.findElement(By.className(searchField)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-nav")));

        //check url
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,  "https://career.softserveinc.com/uk-ua/technology");
    }
}
