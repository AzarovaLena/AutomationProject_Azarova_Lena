package pageObject_Test.saucedemo_Test;

import driver.BaseTest;
import pageObject.saucedemo.CartPage;
import pageObject.saucedemo.CheckOutPage;
import pageObject.saucedemo.LoginPage;
import pageObject.saucedemo.ProductsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Saucedemo_Test extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        cartPage = new CartPage();
        checkOutPage = new CheckOutPage();
        loginPage.openPage();

    }

    @DataProvider(name = "Negative login details")
    public Object[][] inputFalseData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"  ", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username and password do not match any user in this service"},
                {"problem_user", "secret_sauce", ""},
                {"performance_glitch_user", "secret_sauce", ""}
        };
    }

    @Test(dataProvider = "Negative login details", priority = 1)
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

    @Test(priority = 2)
    public void loginPage_Test()  {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clicklLogin();
    }

   @Test(priority = 3)
    public void addProducts_Test() {
        productsPage.imgProductsIsDisplayed(12)
                .titleProductsIsDisplayed(6)
                .priceProductsIsDisplayed(6)
                .addProductsToCart()
                .existProductToCart();
    }

   @Test(priority = 4)
    public void removeProducts_Test() {
        cartPage.cartPageNameIsDisplayed()
                .removeProducts()
                .notExistProductToCart();
    }

    @Test(priority = 5)
    public void checkOutProducts_Test1() {
        productsPage.continueShopping()
                .addProductsToCart()
                .existProductToCart();
        checkOutPage.checkOutProducts()
                .enterFirstName("")
                .enterLastName("")
                .enterZipCode("")
                .clickContinue()
                .checkEmptyString("Error: First Name is required");
    }
   @Test(priority = 6)
    public void checkOutProducts_Test2(){
        checkOutPage.enterFirstName("Zara")
                .enterLastName("Simpsons")
                .enterZipCode("11111")
                .clickContinue()
                .verifyDescription()
                .clickFinish()
                .verifyCheckOutComplete()
                .backToCart()
                .verifyNoProductToCart();
    }

}
