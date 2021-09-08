package PageObject;

import org.openqa.selenium.By;

public class ProductsPage extends BasePage{

    private By imgProducts = By.cssSelector(".inventory_item_img");
    private By titleProducts = By.cssSelector(".inventory_item_name");
    private By PriceProducts = By.cssSelector(".inventory_item_price");
    private By addToCartBtn = By.cssSelector("[name*=backpack]");
    private By moveToCartBtn = By.cssSelector(".shopping_cart_link");
    private By productInCart = By.xpath("//div[contains(text(), 'Backpack')]");
    private By continueShoppingBtn = By.name("continue-shopping");
    private By menuBtn = By.cssSelector("[id*=menu-btn]");
    private By logOutBtn = By.cssSelector("[id*=logout]");

    public ProductsPage continueShopping  () {
        click(continueShoppingBtn);
        return this;
    }
    public  ProductsPage imgProductsIsDisplayed (int amountOfImg) {
        countElementsIsDisplayed(this.imgProducts, amountOfImg);
        return this;
    }
    public  ProductsPage titleProductsIsDisplayed (int amountOfTitles) {
        countElementsIsDisplayed(this.titleProducts, amountOfTitles);
        return this;
    }
    public  ProductsPage priceProductsIsDisplayed (int amountOfPrices) {
        countElementsIsDisplayed(this.PriceProducts, amountOfPrices);
        return this;
    }
    public ProductsPage addProductsToCart (){
        click(this.addToCartBtn);
        return this;
    }
    public ProductsPage existProductToCart (){
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

}
