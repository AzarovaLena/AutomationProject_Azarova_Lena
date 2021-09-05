package Lecture_4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CoogleSearchTest {
    WebDriver driver = null;
    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

   @Test
    public void test1() throws InterruptedException {
       driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("Hello world", Keys.ENTER);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//h3)[12]"))).perform();
        driver.findElement(By.xpath("(//h3)[12]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class=\"h3 font-weight-bold\"]")).isDisplayed());

    }

   @Test
    public void test2() {
        driver.get("https://www.google.by/");
        driver.findElement(By.name("q")).sendKeys("//", Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("(//p)[1]")).getText(), "По запросу // ничего не найдено. ");

    }
    @AfterTest
    public void postconditions() {
        driver.quit();
    }
}
