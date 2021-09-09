package Lecture_10_11;

import Driver.BaseTest;
import Driver.Listener;
import PageObject.CartPage;
import PageObject.ProductsPage;
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
        productsPage = new ProductsPage();
        cartPage = new CartPage();
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
