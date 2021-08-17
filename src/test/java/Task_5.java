import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/*Написать 3 теста по сценарию ниже с различными данными и вариантами.

Открыть сайт https://masterskayapola.ru/kalkulyator/laminata.html
Ввести параметры для расчета.
Нажать на кнопку ‘Рассчитать’.
Проверить полученные значения.
Закрыть окно браузера.
*/

public class Task_5 {

    WebDriver driver = null;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

   @Test
    public void test1() throws InterruptedException {
        Select sel = new Select(driver.findElement(By.name("calc_direct")));
        sel.selectByIndex(0);
        enter ("calc_roomwidth", "3,000");
        enter("calc_roomheight","4,000");
        enter("calc_lamwidth","1250");
        enter("calc_lamheight","198");
        enter("calc_inpack","10");
        enter("calc_price","400");
        enter("calc_bias", "250");
        enter("calc_walldist", "9");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("l_trash"))).perform();
        driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']")).click();
       Thread.sleep(3000);
        List<String> list = new ArrayList<>();
        driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 whiteback']")).forEach(data->System.out.println(data.getText()));
    }
    @Test
    public void test2() throws InterruptedException {
        Select sel = new Select(driver.findElement(By.name("calc_direct")));
        sel.selectByIndex(1);
        enter ("calc_roomwidth", "8,000");
        enter("calc_roomheight","1,000");
        enter("calc_lamwidth","1000");
        enter("calc_lamheight","250");
        enter("calc_inpack","5");
        enter("calc_price","800");
        enter("calc_bias", "500");
        enter("calc_walldist", "15");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("l_trash"))).perform();
        driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']")).click();
        Thread.sleep(3000);
        List<String> list = new ArrayList<>();
        driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 whiteback']")).forEach(data->System.out.println(data.getText()));
    }
    @Test
    public void test3() throws InterruptedException {
        Select sel = new Select(driver.findElement(By.name("calc_direct")));
        sel.selectByIndex(1);
        enter ("calc_roomwidth", "10,000");
        enter("calc_roomheight","10,000");
        enter("calc_lamwidth","120");
        enter("calc_lamheight","80");
        enter("calc_inpack","13");
        enter("calc_price","500");
        enter("calc_bias", "150");
        enter("calc_walldist", "7");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("l_trash"))).perform();
        driver.findElement(By.xpath("//*[@class='btn btn-secondary btn-lg tocalc']")).click();
        Thread.sleep(3000);
        List<String> list = new ArrayList<>();
        driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-12 whiteback']")).forEach(data->System.out.println(data.getText()));
    }
    public void enter (String element, String data) {
        driver.findElement(By.name(element)).clear();
        driver.findElement(By.name(element)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name(element)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name(element)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name(element)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name(element)).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.name(element)).sendKeys(data);
    }

   @AfterTest
    public void postconditions() {
        driver.quit();
    }

}
