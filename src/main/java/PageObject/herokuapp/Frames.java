package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Frames extends BasePage {
    private By title = By.tagName("h3");
    private By iframeId = By.id("mce_0_ifr");
    private By iframeText = By.cssSelector("#tinymce > p");

    private By getFrameLink(String frame) {
        return By.linkText(frame);
    }

    public Frames verifyPageTitle(String title) {
        Assert.assertEquals(getElementText(this.title), title);
        return this;
    }

    public Frames(WebDriver driver) {
        super(driver);
    }

    public Frames clickFrameLink(String frameLink) {
        click(getFrameLink(frameLink));
        return this;
    }

    public Frames verifyFrameText(String expectedText) {
        driver.switchTo().frame(driver.findElement(iframeId));
        Assert.assertEquals(getElementText(iframeText), expectedText);
        return this;
    }

}
