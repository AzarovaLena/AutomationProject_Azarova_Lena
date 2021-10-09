package patterns_Test.herokuapp;

import pageObject.herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import patterns.herokuapp.valueObject.LoginPage_VObject;
import patterns.herokuapp.valueObject.LoginPage_ValueObject;

import static pageObject.herokuapp.HomePageLinksEnum.FORM_AUTHENTICATION;

public class ValueObject_LoginPage_Test extends BaseTest {
    HomePage homePage;
    LoginPage_VObject loginPage;
    LoginPage_ValueObject correctData;
    LoginPage_ValueObject incorrectData;

    @BeforeClass
    public void precondition() {
        homePage = new HomePage();
        homePage.clickLink(FORM_AUTHENTICATION);
        loginPage = new LoginPage_VObject();
        correctData = new LoginPage_ValueObject("tomsmith", "SuperSecretPassword!");
        incorrectData = new LoginPage_ValueObject("User", "11111");
    }
    @Test
    public void verifyLoginPage(){
        loginPage.verifyPageTitle("Login Page")
                .entreUserNameAngPassword(correctData)
                .clickLogin()
                .verifyPageAfterLogin()
                .entreErrorLoginAndPassword(incorrectData)
                .verifyErrorText("Your username is invalid!\n" +
                        "×");

    }

}
