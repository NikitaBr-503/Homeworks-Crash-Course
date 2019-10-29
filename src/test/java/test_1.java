import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class test_1 {

    public WebDriver driver;


    @BeforeTest
    public void before(){
        System.setProperty("webdriver.chrome.driver", "./src/test/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(groups = {"TestOne"})
    public void TestOne(){

        //Open homepage softserve
        driver.get("https://www.softserveinc.com/uk-ua/");

        //Create list of services
        List<WebElement> elements = driver.findElements(By.xpath("//h2[@class='services-nav-heading']"));
        List<String> expectedServices = new ArrayList<>();
        Collections.addAll(expectedServices, "ПРОГРАМНЕ ЗАБЕЗПЕЧЕННЯ", "ХМАРНІ ТЕХНОЛОГІЇ", "ВЕЛИКІ ДАНІ",
                "ШТУЧНИЙ ІНТЕЛЕКТ", "ІНТЕРНЕТ РЕЧЕЙ (IOT)", "СЕРВІСНИЙ ДИЗАЙН", "КІБЕРБЕЗПЕКА", "ЦИФРОВІ ПЛАТФОРМИ", "РОЗШИРЕНА РЕАЛЬНІСТЬ (XR)");
        List<String> actualServices = new ArrayList<>();
        elements.stream().forEach(element -> actualServices.add(element.getAttribute("innerText")));

        //Check quantity services in list
        long quantity = actualServices.stream().count();
        Assert.assertEquals(quantity, 9);
        //Check content in list
        Assert.assertEquals(actualServices, expectedServices);

    }



    @AfterTest
    public void after(){
        driver.quit();
    }

}
