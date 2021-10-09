package pageObject.herokuapp;

import pageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static pageObject.herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class DynamicControls extends BasePage {
    private By checkbox = By.cssSelector("[id=checkbox]");
    private By removeBtn = By.cssSelector("#checkbox-example>button");
    private By textRemoveAdd = By.cssSelector("#checkbox-example>p");
    private By title = By.tagName("h4");
    private By input = By.cssSelector("#input-example>input");
    private By enableInputBtn = By.cssSelector("#input-example>button");
    private By enableText = By.cssSelector("#input-example>p");


    public DynamicControls verifyPageTitle() {
        Assert.assertEquals(getElementText(title), DYNAMIC_CONTROLS.getLinkText());
        return this;
    }
    public DynamicControls checkboxIsDisplayed(){
        displayElements(checkbox);
        return this;
    }

    public DynamicControls clickRemoveBtn() {
        click(removeBtn);
        return this;
    }

    public DynamicControls verifyElementText(String text) {
        wait.until(ExpectedConditions.textToBe(textRemoveAdd, text));
        return this;
    }
    public DynamicControls checkboxNotDisplayed(){
        verifyNoElements(checkbox);
        return this;
    }
    public DynamicControls verifyInputDisabled(){
        wait.until(ExpectedConditions.not(elementToBeClickable(input)));
        return this;
    }
    public DynamicControls clickInputEnableBtn(){
        click(enableInputBtn);
        return this;
    }
    public DynamicControls verifyEnableText(String text) {
        wait.until(ExpectedConditions.textToBe(enableText, text));
        return this;
    }
    public DynamicControls verifyInputEnabled(){
        wait.until(ExpectedConditions.elementToBeClickable(input));
        return this;
    }
}

