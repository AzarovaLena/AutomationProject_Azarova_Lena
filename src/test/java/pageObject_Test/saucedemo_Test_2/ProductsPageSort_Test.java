package pageObject_Test.saucedemo_Test_2;

import driver.BaseTest;
import testng.Listener;
import pageObject.saucedemo.ProductsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static pageObject.saucedemo.ProductsPage.LinksSort.*;

@Listeners({Listener.class})
public class ProductsPageSort_Test extends BaseTest {
    ProductsPage productsPage;

    @BeforeClass
    public void precondition() {
        productsPage = new ProductsPage();
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
