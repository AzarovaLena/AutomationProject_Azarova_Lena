package Lecture_14_Patterns.Saucedemo;

import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import patterns.Saucedemo.Builder.CheckOutPage_BObject;
import patterns.Saucedemo.Builder.CheckOutPage_Builder;
import patterns.Saucedemo.PageFactory_CartPage;

public class Builder_CheckOutPage_Test extends BaseTest {
    CheckOutPage_BObject checkOutPage_bObject;
    PageFactory_CartPage pageFactory_cartPage;
    CheckOutPage_Builder checkOutPage_builder;

    @BeforeClass
    public void precondition() {
       checkOutPage_bObject = new CheckOutPage_BObject(driver);
        pageFactory_cartPage = new PageFactory_CartPage(driver);
        checkOutPage_builder = new CheckOutPage_Builder.Builder()
                .withFirstName("FirstName")
                .withLastName("LastName")
                .withZipCode("11111")
                .build();
    }

    @Test
    public void registrationOnCheckOutPage_Test() {
        pageFactory_cartPage.addProducts()
                .moveToCart();
        checkOutPage_bObject.moveToCheckOutPage()
                .entreRegistrationData(checkOutPage_builder)
                .verifyOverviewPage();

    }
}