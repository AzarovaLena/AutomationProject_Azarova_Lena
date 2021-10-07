package Lecture_10_11;

import driver.BaseTest;
import testng.Listener;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.ProductsPage;
import io.qameta.allure.Link;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class Task_10_11_1 extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        loginPage.openPage();

    }

    @DataProvider(name = "Негативные данные для входа")
    public Object[][] inputFalseData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"  ", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username and password do not match any user in this service"},
                {"problem_user", "secret_sauce", ""},
                {"performance_glitch_user", "secret_sauce", ""}
        };
    }
    @Description("Checking for login errors")
    @Link("https://www.saucedemo.com/")
    @Test(dataProvider = "Негативные данные для входа")
    public void checkErrorsLoginToApp_Test(String userName, String password, String expectedErrorText)  {
        loginPage.enterUsername(userName)
                .enterPassword(password)
                .clicklLogin();
        if (expectedErrorText.isEmpty()) {
            loginPage.NoErrorText();
            productsPage.clickMenu()
                    .clickLogOut();
        } else {
            loginPage.checkErrorText(expectedErrorText);
        }
    }

}
