package Lecture_9;

import Driver.BaseTest;
import PageObject.CartPage;
import PageObject.CheckOutPage;
import PageObject.LoginPage;
import PageObject.ProductsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;

    @BeforeClass
    public void precondition() {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        loginPage.openPage();
    }

   @Test(priority = 1)
    public void loginPage_Test1() {
        loginPage.enterUsername("locked_out_user")
                .enterPassword("secret_sauce")
                .clicklLogin()
                .checkErrorText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(priority = 2)
    public void loginPage_Test2() {
        loginPage.enterUsername("  ")
                .enterPassword("secret_sauce")
                .clicklLogin()
                .checkErrorText("Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority = 3)
    public void loginPage_Test3() {
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clicklLogin();
    }

   @Test(priority = 4)
    public void addProducts_Test() {
        productsPage.imgProductsIsDisplayed(12)
                .titleProductsIsDisplayed(6)
                .priceProductsIsDisplayed(6)
                .addProductsToCart()
                .existProductToCart();
    }

   @Test(priority = 5)
    public void removeProducts_Test() {
        cartPage.cartPageNameIsDisplayed()
                .removeProducts()
                .notExistProductToCart();
    }

    @Test(priority = 6)
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
    @Test(priority = 7)
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
