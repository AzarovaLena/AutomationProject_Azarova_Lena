import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*
1.	Создать отдельный Java-класс Task_6 с тестом, сценарий:
a.	Залогиниться https://www.saucedemo.com/
b.	Добавить товар в корзину
c.	Перейти в корзину
d.	Проверить (assertEquals) стоимость товара и его имя в корзине
*/
public class Task_6 {
    WebDriver driver = null;

    @BeforeTest
    public void preconditions() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void test1 () throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("submit-button")).click();
        driver.findElement(By.xpath("//a[@id=\"item_4_title_link\"]")).click();
        driver.findElement(By.cssSelector(".btn.btn_primary.btn_small.btn_inventory")).click();
        driver.findElement(By.xpath("//div[@class=\"left_component\"]//descendant::button")).click();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']")).click();
        driver.findElement(By.cssSelector("[data-test*=labs]")).click();
        driver.findElement(By.xpath("//div[contains(@style,'z-index: 1000')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inventory_sidebar_link")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Onesie')]")).click();
        driver.findElement(By.cssSelector("[data-test$=onesie]")).click();
        driver.findElement(By.tagName("span")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"inventory_item_name\" and contains(text(),'Backpack')]")).getText(), "Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"29.99\"]")).getText(), "$29.99");
        Assert.assertEquals(driver.findElement(By.cssSelector("[id=\"item_0_title_link\"]")).getText(), "Sauce Labs Bike Light");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"9.99\"]")).getText(), "$9.99");
        Assert.assertEquals(driver.findElement(By.id("item_2_title_link")).getText(), "Sauce Labs Onesie");
        Assert.assertEquals(driver.findElement(By.xpath("//div[text()=\"7.99\"]")).getText(), "$7.99");


    }
    @AfterTest
    public void postconditions() {
        driver.quit();
    }

}
