import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test_2 {
    @Test
    public void TestTwo(){
        System.setProperty("webdriver.chrome.driver", "./src/test/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open homepage Softserve
        driver.get("https://www.softserveinc.com/uk-ua/");
        driver.navigate().refresh();

        //Wait and open search page
        WebDriverWait searchWait = new WebDriverWait(driver, 10);
        searchWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class = 'header-search header-nav-item']")));
        driver.findElement(By.xpath("//a[@class = 'header-search header-nav-item']")).click();

        //input data for searching
        driver.findElement(By.id("p_lt_ctl04_pageplaceholder_p_lt_ctl01_SmartSearchBox_txtWord")).sendKeys("Test Automation");
        driver.findElement(By.id("p_lt_ctl04_pageplaceholder_p_lt_ctl01_SmartSearchBox_btnSearch")).click();

        //Data returned?
        Boolean backData = driver.findElement(By.id("p_lt_ctl04_pageplaceholder_p_lt_ctl01_SmartSearchResults_srchResults_pnlSearchResults")).isDisplayed();
        Assert.assertEquals(backData, Boolean.TRUE);

        // The test contains the requested information?
        String text = driver.findElement(By.className("search-result-title")).getAttribute("textContent");
        Boolean correctData = text.contains("Test Automation");
        Assert.assertEquals(correctData, Boolean.TRUE );

        driver.quit();
    }
}
