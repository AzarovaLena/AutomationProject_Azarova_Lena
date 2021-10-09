package patterns.saucedemo;

import pageObject.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageFactory_CartPage extends BasePage {
    @FindBy (xpath= "//span[text()='Your Cart']")
    WebElement cartPageName;
    @FindBy (css= "[id*=remove]")
    WebElement removeBtn;
    @FindBy (css= ".inventory_item_name")
    WebElement productInCart;
    @FindBy (css= ".shopping_cart_link")
    WebElement moveToCartBtn;
    @FindBy (css = "[name*=add-to-cart]")
    WebElement addToCartBtn;

    public PageFactory_CartPage (){
        initElements(driver, this);
    }
    public PageFactory_CartPage addProducts(){
        addToCartBtn.click();
        return this;
    }
    public PageFactory_CartPage moveToCart(){
        moveToCartBtn.click();
        return this;
    }
    public PageFactory_CartPage verifyCartPage(){
        Assert.assertTrue(cartPageName.isDisplayed());
        return this;
    }
    public PageFactory_CartPage verifyProductsInCart(){
        Assert.assertTrue(productInCart.isDisplayed());
        return this;
    }
    public PageFactory_CartPage removeProducts(){
        removeBtn.click();
        return this;
    }




}
