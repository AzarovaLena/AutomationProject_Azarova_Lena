package PageObject.Herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;

import static PageObject.Herokuapp.HomePageLinksEnum.CONTEXT_MENU;

public class ContextMenu extends BasePage {
    private By title = By.tagName("h3");
    private By hotSpot = By.id("hot-spot");

    public ContextMenu verifyPageTitle (){
        Assert.assertEquals(getElementText(title), CONTEXT_MENU.getLinkText());
        return this;
    }
    public ContextMenu verifyAlertText (){
       actions.contextClick(driver.findElement(hotSpot)).perform();
       Alert alert = driver.switchTo().alert();
       Assert.assertEquals(alert.getText(), "You selected a context menu");
       alert.accept();
        return this;
    }


}
