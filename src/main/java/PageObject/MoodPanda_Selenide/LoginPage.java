package PageObject.MoodPanda_Selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePageSelenide{

    SelenideElement loginTab = $(byXpath("//li/a[@href=\"/Login/\"]"));
    SelenideElement userName = $("#ContentPlaceHolderContent_TextBoxEmail");
    SelenideElement password = $("#ContentPlaceHolderContent_TextBoxPassword");
    SelenideElement loginBtn = $ ("#ContentPlaceHolderContent_ButtonLogin");
    SelenideElement errorMessage =$("#ContentPlaceHolderContent_MessageError");

    public LoginPage clickLoginTab(){
        loginTab.click();
        return this;
    }
    public LoginPage entreUserName(String userName){
        entreData(this.userName, userName);
        return this;
    }
    public LoginPage entrePassword(String password){
        entreData(this.password, password);
        return this;
    }
    public LoginPage clickLoginBtn(){
        loginBtn.click();
        return this;
    }
    public LoginPage checkErrorMessage(String expectedText){
        errorMessage.shouldHave(matchText(expectedText));
        return this;
    }


}
