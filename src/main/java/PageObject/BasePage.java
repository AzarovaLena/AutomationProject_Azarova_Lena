package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    protected WebDriver driver;
    WebDriverWait wait;

    protected BasePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
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
        for (By element : elements) {
            Assert.assertTrue(driver.findElement(element).isDisplayed());
        }
    }
    protected void verifyNoElements(By element) {
        Assert.assertTrue(driver.findElements(element).size() < 1);
    }
}


