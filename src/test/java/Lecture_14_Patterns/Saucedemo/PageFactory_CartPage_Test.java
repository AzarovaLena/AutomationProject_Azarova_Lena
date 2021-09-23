package Lecture_14_Patterns.Saucedemo;

import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import patterns.Saucedemo.PageFactory_CartPage;

public class PageFactory_CartPage_Test extends BaseTest {
    PageFactory_CartPage pageFactory_cartPage;

    @BeforeClass
    public void precondition() {
        pageFactory_cartPage = new PageFactory_CartPage(driver);
    }

    @Test
    public void checkCartPage_Test(){
        pageFactory_cartPage.addProducts()
                .moveToCart()
                .verifyCartPage()
                .verifyProductsInCart()
                .removeProducts();
    }

}
