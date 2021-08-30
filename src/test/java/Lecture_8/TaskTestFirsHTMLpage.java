package Lecture_8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskTestFirsHTMLpage {
    WebDriver driver = null;

    @BeforeMethod
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///E:/project/AutomationProject_Azarova_Lena/src/test/java/Lecture_8/FirstHTMLpage.html");

    }
   // @Test
    public void CheckOrderForm  () {
        sel().selectByIndex(1);
        driver.findElement(By.name("name")).sendKeys("Азарова Елена Николаевна");
        driver.findElement(By.name("email")).sendKeys("11111@gmail.com");
        driver.findElement(By.xpath("//*[text()='Заказать']")).click();
    }
    @Test
    public void CheckTables () throws InterruptedException {
        List<WebElement> heads = driver.findElements(By.xpath("//table[@id='table2']//th"));
        Map<String, List<String>> data = new HashMap<>();
        for (int index = 0; index < heads.size(); index++) {
            List<String> columnData = new ArrayList<>();
            List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table2']//tr//following::tr//td[" + (index + 1) + "]"));
            for (WebElement column : columns) {
                columnData.add(column.getText());
            }
            data.put(heads.get(index).getText(), columnData);
        }
        data.forEach((k, v) -> System.out.println(k + " -> " + v));

        Assert.assertTrue(driver.findElement(By.cssSelector("[alt*=фото]")).isDisplayed());
        driver.findElement(By.cssSelector("[target='_blank']")).click();
        ArrayList<String> tabs_windows = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs_windows.get(1));
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.cssSelector(".search-f")).isDisplayed());

    }


    private Select sel (){
        return new Select(driver.findElement(By.id("time")));
    }

   @AfterMethod
    public void postconditions() {
        driver.quit();
    }
}
