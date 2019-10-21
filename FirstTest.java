import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTest {
    @Test
    public void FirstTest() throws InterruptedException {
        //Запуск хром драйвера
        System.setProperty("webdriver.chrome.driver", "E:\\IDEA\\Projects\\src\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //open google link
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        //searching
        driver.findElement(By.name("q")).sendKeys("softserve it academy");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //checked name of link
        String nameOfFirstLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/div[1]/a[1]/h3")).getText();
        Assert.assertEquals(nameOfFirstLink,  "Школа програмування : SoftServe провідна IT-компанія");

        //open page
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div/div/div[1]/div/div/div[1]/a[1]/h3")).click();

        //checked url
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,  "https://career.softserveinc.com/uk-ua/technology");

        //searching course
        driver.findElement(By.name("search")).sendKeys("Test automation");
        driver.findElement(By.name("search")).sendKeys(Keys.ENTER);


        //Open course page
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"vacancy-content\"]/article/a"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        //Check name course on the course page
        String nameText = driver.findElement(By.className("big-text")).getText();
        Assert.assertEquals(nameText,  "TEST AUTOMATION WITH JAVA, C#, PYTHON");

        Thread.sleep(2000);
        driver.close();
    };

}
