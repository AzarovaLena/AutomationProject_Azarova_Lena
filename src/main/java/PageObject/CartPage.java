package PageObject;

import org.openqa.selenium.By;

public class CartPage extends BasePage{
    private By cartPageName = By.xpath("//span[text()='Your Cart']");
    private By removeBtn = By.cssSelector("[id*='backpack']");
    private By productInCart = By.xpath("//div[contains(text(), 'Backpack')]");

    public CartPage cartPageNameIsDisplayed(){
        displayElements(this.cartPageName);
        return this;
    }
    public CartPage removeProducts(){
        click(this.removeBtn);
        return this;
    }
    public CartPage notExistProductToCart(){
        verifyNoElements(productInCart);
        return this;
    }


}
