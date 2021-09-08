package Lecture_10_11;

import Driver.BaseTest;
import PageObject.LoginPage;
import PageObject.ProductsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_10_11_login extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        loginPage.openPage();

    }
    @Test()
    public void loginToApp_Test() {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clicklLogin();
        productsPage.imgProductsIsDisplayed(12);
    }
}
