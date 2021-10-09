package pageObject.saucedemo;

import pageObject.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CheckOutPage extends BasePage {
     private By checkOutBtn = By.name("checkout");
    private By firstNameStr = By.cssSelector("[data-test=firstName]");
    private By lastNameStr = By.cssSelector("[data-test=lastName]");
    private By ZipCodeStr = By.cssSelector("[data-test=postalCode]");
    private By continueBtn = By.cssSelector("[data-test=continue]");
    private By nameCheckOutProduct = By.xpath("//div[contains(text(), 'Backpack')]");
    private By priceCheckOutProduct= By.xpath("//div[text()='$']");
    private By paymentInformation = By.xpath("//div[contains(text(), 'SauceCard')]");
    private By totalPrice = By.cssSelector(".summary_total_label");
    private By finishBtn = By.name("finish");
    private By checkOutComplete = By.cssSelector(".complete-header");
    private By CartBtn = By.cssSelector(".shopping_cart_link");
    private By errorText = By.cssSelector("[data-test=error]");


    public  CheckOutPage checkOutProducts (){
        click(checkOutBtn);
        return  this;
    }
    public CheckOutPage enterFirstName(String FirstName){
        enter(firstNameStr, FirstName);
        return  this;
    }
    public CheckOutPage enterLastName(String LastName){
        enter(lastNameStr, LastName);
        return  this;
    }
    public CheckOutPage enterZipCode(String ZipCode){
        enter(ZipCodeStr, ZipCode);
        return  this;
    }
    public CheckOutPage checkEmptyString(String expectedText){
        Assert.assertEquals(getElementText(errorText), expectedText);
        return this;
    }

    public CheckOutPage clickContinue (){
        click(continueBtn);
        return  this;
    }
    public CheckOutPage verifyDescription(){
        displayElements(nameCheckOutProduct, priceCheckOutProduct, paymentInformation, totalPrice);
        return  this;
    }
    public CheckOutPage clickFinish(){
        click(finishBtn);
        return this;
    }
    public CheckOutPage verifyCheckOutComplete(){
        displayElements(checkOutComplete);
        return this;
    }
    public CheckOutPage backToCart(){
        click(CartBtn);
        return this;
    }
    public CheckOutPage verifyNoProductToCart(){
        verifyNoElements(nameCheckOutProduct);
        return this;
    }


}
