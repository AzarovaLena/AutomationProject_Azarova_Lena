package Lecture_14_Patterns.Herokuapp;

import PageObject.Herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import patterns.Herokuapp.Builder.LoginPage_BObject;
import patterns.Herokuapp.Builder.LoginPage_Builder;

import static PageObject.Herokuapp.HomePageLinksEnum.FORM_AUTHENTICATION;

public class Builder_LoginPage_Test extends BaseTest {
    HomePage homePage;
    LoginPage_BObject loginPage;
    LoginPage_Builder correctData = LoginPage_Builder.builder()
            .userName("tomsmith")
            .password("SuperSecretPassword!")
            .build();

    @BeforeClass
    public void precondition() {
        homePage = new HomePage();
        homePage.clickLink(FORM_AUTHENTICATION);
        loginPage = new LoginPage_BObject();

    }
    @Test
    public void verifyLoginPage(){
        loginPage.verifyPageTitle("Login Page")
                .entreUserNameAngPassword(correctData)
                .clickLogin()
                .verifyPageAfterLogin()
                .entreOnlyUserName(correctData)
                .verifyErrorText("Your password is invalid!\n" +
                        "×")
                .entreOnlyPassword(correctData)
                .verifyErrorText("Your username is invalid!\n" +
                        "×");
    }
}
