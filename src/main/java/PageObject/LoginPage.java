package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public LoginPage (WebDriver driver) {
        super(driver);
    }
    private By username = By.name("user-name");
    private By password = By.name("password");
    private By loginBtn = By.name("login-button");
    private By errorText = By.tagName("h3");

    public LoginPage openPage  () {
        open("https://www.saucedemo.com/");
        return this;
    }
    public LoginPage enterUsername(String username) {
       enter(this.username, username);
        return this;
    }
    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }
    public LoginPage clicklLogin () {
        click(this.loginBtn);
        return this;
    }
    public LoginPage checkErrorText(String expectedText){
        Assert.assertEquals(getElementText(this.errorText), expectedText);
        return this;
    }
    public LoginPage NoErrorText (){
        verifyNoElements(this.errorText);
        return this;
    }

    }
