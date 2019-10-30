import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class test_2 {

    public WebDriver driver;

    @BeforeSuite
    public void before(){
        System.setProperty("webdriver.chrome.driver", "./src/test/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void TestTwo() throws InterruptedException {

        //Open homepage Softserve
        driver.get("https://www.softserveinc.com/uk-ua/");
        driver.navigate().refresh();

        //Wait and open search page
        WebDriverWait searchWait = new WebDriverWait(driver, 20);
        searchWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class = 'header-search header-nav-item']")));
       // Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class = 'header-search header-nav-item']")).click();

        //input data for searching
        driver.findElement(By.xpath("//*[starts-with(@class, 'form')]")).sendKeys("Test Automation");
        searchWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[starts-with(@value, ' Пошук')]")));
        driver.findElement(By.xpath("//*[starts-with(@value, ' Пошук')]")).click();

        //Data returned?
        Boolean backData = driver.findElement(By.xpath("//*[starts-with(@class,'search-results')]")).isDisplayed();
        Assert.assertEquals(backData, Boolean.TRUE);

        // The test contains the requested information?
        String text = driver.findElement(By.className("search-result-title")).getAttribute("textContent");
        Boolean correctData = text.contains("Test Automation");
        Assert.assertEquals(correctData, Boolean.TRUE );
    }

    @AfterSuite
    public void after (){
        driver.quit();
    }
}
