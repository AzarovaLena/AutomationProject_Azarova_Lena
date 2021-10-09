package pageObject.saucedemo;

import pageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    private By imgProducts = By.cssSelector(".inventory_item_img");
    private By titleProducts = By.cssSelector(".inventory_item_name");
    private By PriceProducts = By.cssSelector(".inventory_item_price");
    private By addToCartBtn = By.cssSelector("[name*=add-to-cart]");
    private By moveToCartBtn = By.cssSelector(".shopping_cart_link");
    private By productInCart = By.cssSelector(".inventory_item_name");
    private By continueShoppingBtn = By.name("continue-shopping");
    private By menuBtn = By.cssSelector("[id*=menu-btn]");
    private By logOutBtn = By.cssSelector("[id*=logout]");
    private By products = By.cssSelector(".inventory_item_name");
    private By prices = By.cssSelector(".inventory_item_price");
    private By productSortContainerBtn = By.cssSelector(".product_sort_container");
    private By sortAzBtn = By.cssSelector("[value=az]");
    private By sortZaBtn = By.cssSelector("[value=za]");
    private By sortLoHiPriceBtn = By.cssSelector("[value=lohi]");
    private By sortHiLoBtn = By.cssSelector("[value=hilo]");


    public ProductsPage continueShopping() {
        click(continueShoppingBtn);
        return this;
    }

    public ProductsPage imgProductsIsDisplayed(int amountOfImg) {
        countElementsIsDisplayed(this.imgProducts, amountOfImg);
        return this;
    }

    public ProductsPage titleProductsIsDisplayed(int amountOfTitles) {
        countElementsIsDisplayed(this.titleProducts, amountOfTitles);
        return this;
    }

    public ProductsPage priceProductsIsDisplayed(int amountOfPrices) {
        countElementsIsDisplayed(this.PriceProducts, amountOfPrices);
        return this;
    }

    public ProductsPage addProductsToCart() {
        click(this.addToCartBtn);
        return this;
    }

    public ProductsPage existProductToCart() {
        click(this.moveToCartBtn);
        displayElements(this.productInCart);
        return this;
    }

    public ProductsPage clickMenu() {
        click(this.menuBtn);
        return this;
    }
    public ProductsPage clickLogOut() {
        click(this.logOutBtn);
        return this;
    }

    public ProductsPage clickProductSortContainer() {
        click(productSortContainerBtn);
        return this;
    }

    protected void sortProductZa() {
        List<String> expectedData = driver.findElements(products).stream().map(data -> data.getText()).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        List<String> actualData = driver.findElements(products).stream().map(data -> data.getText()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
    }
    protected void sortProductAz() {
            List<String> expectedData = driver.findElements(products).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
            List<String> actualData = driver.findElements(products).stream().map(data -> data.getText()).collect(Collectors.toList());
            Assert.assertEquals(expectedData, actualData);
        }

    public ProductsPage sortPriceLoHi() {
        List<String> list1 = driver.findElements(prices).stream().map(data -> data.getText()).collect(Collectors.toList());
        List<Double> actualData = list1.stream().map(data -> Double.parseDouble(data.replace("$", ""))).collect(Collectors.toList());
        List<Double> expectedData = list1.stream().map(data -> Double.parseDouble(data.replace("$", ""))).sorted().collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }
    public ProductsPage sortPriceHiLo () {
        List<String> list1 = driver.findElements(prices).stream().map(data -> data.getText()).collect(Collectors.toList());
        List<Double> actualData = list1.stream().map(data -> Double.parseDouble(data.replace("$", ""))).collect(Collectors.toList());
        List<Double> expectedData = list1.stream().map(data -> Double.parseDouble(data.replace("$", ""))).sorted(Collections.reverseOrder()).collect(Collectors.toList());
        Assert.assertEquals(expectedData, actualData);
        return this;
    }
    public enum LinksSort {
        AZ,
        ZA,
        LOHI,
        HILO
    }

    public ProductsPage verifyProductsSorted(LinksSort links) {
        switch (links) {
            case AZ:
                click(sortAzBtn);
                sortProductAz();
            case ZA:
                click(sortZaBtn);
                sortProductZa();
            case LOHI:
                click(sortLoHiPriceBtn);
                sortPriceLoHi();
            case HILO:
                click(sortHiLoBtn);
                sortPriceHiLo();
        }
        return this;
    }


}
