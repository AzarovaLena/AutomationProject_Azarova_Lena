package patterns.Herokuapp.ValueObject;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage_VObject extends BasePage {

    private By userName = By.id ("username");
    private By password = By.id ("password");
    private By loginBtn = By.className("radius");
    private By title = By.tagName("h2");
    private By titleAfterLogin = By.cssSelector(".icon-lock");
    private By logoutBtn = By.cssSelector("[class*=button]");
    private By errorText =By.id("flash");

    public LoginPage_VObject verifyPageTitle(String expectedTitle) {
        Assert.assertEquals(getElementText(title), expectedTitle);
        return this;
    }
    public LoginPage_VObject entreUserNameAngPassword(LoginPage_ValueObject correctData){
        enter(userName, correctData.getUserName());
        enter(password, correctData.getPassword());
        return this;
    }
    public LoginPage_VObject clickLogin (){
        click(loginBtn);
        return this;
    }
    public LoginPage_VObject verifyPageAfterLogin (){
        displayElements(titleAfterLogin);
        click(logoutBtn);
        return this;
    }
    public LoginPage_VObject entreErrorLoginAndPassword(LoginPage_ValueObject incorrectData){
        enter(userName, incorrectData.getUserName());
        enter(password, incorrectData.getPassword());
        click(loginBtn);
        return this;
    }
    public LoginPage_VObject verifyErrorText(String expectedText){
        Assert.assertEquals(getElementText(errorText), expectedText);
        return this;
    }

}
