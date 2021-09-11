package Lecture_10_11;

import Driver.BaseTest;
import Driver.Listener;
import PageObject.ProductsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static PageObject.ProductsPage.LinksSort.*;

@Listeners({Listener.class})
public class Task_10_11_3 extends BaseTest {
    ProductsPage productsPage;

    @BeforeClass
    public void precondition() {
        productsPage = new ProductsPage(driver);
    }

    @Description("Checking the sorting in the container on the product page")
    @Link("https://www.saucedemo.com/inventory.html")
    @Test
    public void checkSortContainer_Test() {
        productsPage.clickProductSortContainer()
                .verifyProductsSorted(ZA)
                .verifyProductsSorted(AZ)
                .verifyProductsSorted(LOHI)
                .verifyProductsSorted(HILO);
    }

}
