package pageObject;

import driver.DriverCreation;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import properties.PropertyReader;

import java.util.Properties;

@Log4j2
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;

    protected BasePage () {
        this.driver = DriverCreation.getDriver();
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        properties = PropertyReader.getProperties();
    }

    protected void open(){
        driver.get(properties.getProperty("url"));
    }

    protected void open(String url) {
        log.info("Open page :: " + url);
        driver.get(url);
    }

    protected void enter(By element, CharSequence... charSequences) {
       log.info("Enter in element :: " + element);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequences);
    }

    protected void click(By element) {
       log.info("Click on element :: " + element);
        driver.findElement(element).click();
    }

    protected String getElementText(By element) {
       log.info("Find element :: " + element);
        return driver.findElement(element).getText();
        
    }

    protected void countElementsIsDisplayed(By element, int amountElements) {log.info("Find elements :: " + element);
        Assert.assertTrue(driver.findElements(element).size() == amountElements);
    }

    protected void displayElements(By... elements) {
       log.info("Verify that element :: " + elements + " is displayed.");
        for (By element : elements ) {
            Assert.assertFalse(driver.findElements(element).isEmpty());
        }
    }
    protected void verifyNoElements(By element) {
        log.info("Verify that element :: " + element + " not displayed.");
        Assert.assertTrue(driver.findElements(element).size() < 1);
    }

    public void pause (Integer seconds){
        try {
            long time = seconds * 1000;
            log.info("Sleep :: " + time);
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


