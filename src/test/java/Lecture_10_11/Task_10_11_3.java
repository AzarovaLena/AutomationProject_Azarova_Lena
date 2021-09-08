package Lecture_10_11;

import Driver.BaseTest;
import PageObject.ProductsPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.ProductsPage.LinksSort.*;

public class Task_10_11_3 extends BaseTest {
    ProductsPage productsPage;

    @BeforeClass
    public void precondition() {
        productsPage = new ProductsPage();
    }

    @Test
    public void checkSortContainer_Test() {
        productsPage.clickProductSortContainer()
                .verifyProductsSorted(ZA)
                .verifyProductsSorted(AZ)
                .verifyProductsSorted(LOHI)
                .verifyProductsSorted(HILO);
    }

}
