package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import properties.PropertyReader;

import java.util.Properties;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;

    protected BasePage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);
        properties = PropertyReader.getProperties();
    }

    protected void open(){
        driver.get(properties.getProperty("url"));
    }

    protected void open(String url) {
        driver.get(url);
    }
    protected void enter(By element, CharSequence... charSequences) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
        driver.findElement(element).click();
    }

    protected String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    protected void countElementsIsDisplayed(By element, int amountElements) {
        Assert.assertTrue(driver.findElements(element).size() == amountElements);
    }

    protected void displayElements(By... elements) {
        for (By element : elements ) {
            Assert.assertFalse(driver.findElements(element).isEmpty());
        }
    }
    protected void verifyNoElements(By element) {
        Assert.assertTrue(driver.findElements(element).size() < 1);
    }

    public void pause (Integer seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


