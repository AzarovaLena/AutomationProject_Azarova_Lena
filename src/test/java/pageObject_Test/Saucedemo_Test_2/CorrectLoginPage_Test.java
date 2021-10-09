package pageObject_Test.Saucedemo_Test_2;

import driver.BaseTest;
import testng.Listener;
import pageObject.saucedemo.LoginPage;
import pageObject.saucedemo.ProductsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class CorrectLoginPage_Test extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        loginPage.openPage();
    }

    @Description("Checking correct data for login")
    @Link("https://www.saucedemo.com/")
    @Test()
    public void loginToApp_Test() {
        loginPage.enterCorrectUsername()
                .enterCorrectPassword()
                .clicklLogin();
        productsPage.imgProductsIsDisplayed(12);
    }
}
