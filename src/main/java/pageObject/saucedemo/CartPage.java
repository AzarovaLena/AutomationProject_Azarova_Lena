package pageObject.saucedemo;

import pageObject.BasePage;
import org.openqa.selenium.By;

public class CartPage extends BasePage {

    private By cartPageName = By.xpath("//span[text()='Your Cart']");
    private By removeBtn = By.cssSelector("[id*=remove]");
    private By productInCart = By.cssSelector(".inventory_item_name");

    public CartPage cartPageNameIsDisplayed(){
        displayElements(this.cartPageName);
        return this;
    }
    public CartPage removeProducts(){
        click(this.removeBtn);
        return this;
    }
    public CartPage notExistProductToCart(){
        verifyNoElements(this.productInCart);
        return this;
    }


}
