package patterns.Saucedemo.ValueObject;

import PageObject.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckOutPage_VObject extends BasePage {
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

    public CheckOutPage_VObject(){
        initElements(driver, this);
    }
    public CheckOutPage_VObject moveToCheckOutPage(){
        checkOutBtn.click();
        return  this;
    }
    public CheckOutPage_VObject entreRegistrationData(CheckOutPage_ValueObject data){
        firstNameStr.sendKeys(data.getFirstName());
        lastNameStr.sendKeys(data.getLastName());
        ZipCodeStr.sendKeys(data.getZipCode());
        return  this;
    }
    public CheckOutPage_VObject verifyOverviewPage(){
        continueBtn.click();
        Assert.assertTrue(checkOutOverview.isDisplayed());
        return  this;
    }
}
