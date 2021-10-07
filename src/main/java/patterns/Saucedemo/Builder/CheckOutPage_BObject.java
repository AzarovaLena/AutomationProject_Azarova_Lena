package patterns.Saucedemo.Builder;

import PageObject.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckOutPage_BObject extends BasePage {
    @FindBy(name = "checkout")
    WebElement checkOutBtn;
    @FindBy(css = "[data-test=firstName]")
    WebElement firstNameStr;
    @FindBy(css = "[data-test=lastName]")
    WebElement lastNameStr;
    @FindBy(css = "[data-test=postalCode]")
    WebElement ZipCodeStr;
    @FindBy(css = "[data-test=continue]")
    WebElement continueBtn;
    @FindBy(css = ".header_secondary_container")
    WebElement checkOutOverview;

    public CheckOutPage_BObject(){

        initElements(driver, this);
    }

    public CheckOutPage_BObject moveToCheckOutPage(){
        checkOutBtn.click();
        return  this;
    }
    public CheckOutPage_BObject entreRegistrationData(CheckOutPage_Builder check){
        firstNameStr.sendKeys(check.firstName);
        lastNameStr.sendKeys(check.lastName);
        ZipCodeStr.sendKeys(check.zipCode);
        return  this;
    }
    public CheckOutPage_BObject verifyOverviewPage(){
        continueBtn.click();
        Assert.assertTrue(checkOutOverview.isDisplayed());
        return  this;
    }
}
