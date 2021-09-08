package Lecture_10_11;

import Driver.BaseTest;
import PageObject.CartPage;
import PageObject.ProductsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_10_11_2 extends BaseTest {
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeClass
    public void precondition() {
        productsPage = new ProductsPage();
        cartPage = new CartPage();
    }

    @Test( invocationCount = 3)
    public void addAndRemoveProductsToCart_Test() {
        productsPage.addProductsToCart()
                .existProductToCart();
        cartPage.removeProducts()
                .notExistProductToCart();
        productsPage.continueShopping();
    }
}
