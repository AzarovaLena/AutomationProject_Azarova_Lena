package patterns.herokuapp;

import pageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageFactory_Frames extends BasePage {
    @FindBy (tagName = "h3")
    WebElement title;
    @FindBy (id = "mce_0_ifr")
    WebElement iframeId;
    @FindBy (css = "#tinymce > p")
    WebElement iframeText;

    public PageFactory_Frames() {
        initElements(driver, this);
    }

    private By getFrameLink(String frame) {
        return By.linkText(frame);
    }

    public PageFactory_Frames verifyPageTitle(String title2) {
        Assert.assertEquals(title.getText(), title2);
        return this;
    }

    public PageFactory_Frames clickFrameLink(String frameLink) {
        click(getFrameLink(frameLink));
        return this;
    }

    public PageFactory_Frames verifyFrameText(String expectedText) {
        driver.switchTo().frame(iframeId);
        Assert.assertEquals(iframeText.getText(), expectedText);
        return this;
    }
}
