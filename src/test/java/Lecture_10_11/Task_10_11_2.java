package Lecture_10_11;

import driver.BaseTest;
import testng.Listener;
import PageObject.Saucedemo.CartPage;
import PageObject.Saucedemo.ProductsPage;
import io.qameta.allure.Link;
import jdk.jfr.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Listener.class})
public class Task_10_11_2 extends BaseTest {
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeClass
    public void precondition() {
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Description("Adding and removing products from the cart")
    @Link("https://www.saucedemo.com/inventory.html")
    @Test(invocationCount = 3)
    public void addAndRemoveProductsToCart_Test() {
        productsPage.addProductsToCart()
                .existProductToCart();
        cartPage.removeProducts()
                .notExistProductToCart();
        productsPage.continueShopping();
    }
}
