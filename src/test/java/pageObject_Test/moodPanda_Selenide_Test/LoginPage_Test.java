package pageObject_Test.moodPanda_Selenide_Test;

import pageObject.moodPanda_Selenide.LoginPage;
import driver.BaseTestSelenide;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPage_Test extends BaseTestSelenide {

    @BeforeTest
    public void preconditions() {
        get(LoginPage.class)
                .clickLoginTab();
    }

    @DataProvider(name = "data for login form")
    public Object[][] inputDataForLogin() {
        return new Object[][]{
                {"user@mail.ru", "User123", "Error: Could not find account. Forgot Password?"},
                {"", " ", "Error: Could not find account. Forgot Password?"},
                {"#@$^%$#!$%^&%$###$$$@@@@@", "#@$^%$#!$%^&%$###$$$@@@@@", "Error: Could not find account. Forgot Password?"}
        };
    }


   @Test(dataProvider = "data for login form")
    @Description("checking login form")
    public void checkLoginForm_Test(String userName, String password, String expectedText) {
        get(LoginPage.class)
                .entreUserName(userName)
                .entrePassword(password)
                .clickLoginBtn()
                .checkErrorMessage(expectedText);
    }


}
