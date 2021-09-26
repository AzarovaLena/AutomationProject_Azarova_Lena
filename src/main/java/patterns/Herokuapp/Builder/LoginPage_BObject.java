package patterns.Herokuapp.Builder;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage_BObject extends BasePage {

    private By userName = By.id ("username");
    private By password = By.id ("password");
    private By loginBtn = By.className("radius");
    private By title = By.tagName("h2");
    private By titleAfterLogin = By.cssSelector(".icon-lock");
    private By logoutBtn = By.cssSelector("[class*=button]");
    private By errorText =By.id("flash");

        public LoginPage_BObject verifyPageTitle(String expectedTitle) {
        Assert.assertEquals(getElementText(title), expectedTitle);
        return this;
    }
    public LoginPage_BObject entreUserNameAngPassword(LoginPage_Builder correctData){
        enter(userName, correctData.userName);
        enter(password, correctData.password);
        return this;
    }
    public LoginPage_BObject clickLogin (){
        click(loginBtn);
        return this;
    }
    public LoginPage_BObject verifyPageAfterLogin (){
        displayElements(titleAfterLogin);
        click(logoutBtn);
        return this;
    }
    public LoginPage_BObject entreOnlyUserName(LoginPage_Builder userName){
        enter(this.userName, userName.userName);
        click(loginBtn);
        return this;
    }
    public LoginPage_BObject entreOnlyPassword(LoginPage_Builder password){
        enter(this.password, password.password);
        click(loginBtn);
        return this;
    }

    public LoginPage_BObject verifyErrorText(String expectedText){
        Assert.assertEquals(getElementText(errorText), expectedText);
        return this;
    }


}
