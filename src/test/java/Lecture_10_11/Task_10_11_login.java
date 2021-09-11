package Lecture_10_11;

import Driver.BaseTest;
import Driver.Listener;
import PageObject.LoginPage;
import PageObject.ProductsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class Task_10_11_login extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        loginPage.openPage();
    }

    @Description("Checking correct data for login")
    @Link("https://www.saucedemo.com/")
    @Test()
    public void loginToApp_Test() {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clicklLogin();
        productsPage.imgProductsIsDisplayed(12);
    }
}
