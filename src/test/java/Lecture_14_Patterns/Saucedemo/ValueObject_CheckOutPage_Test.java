package Lecture_14_Patterns.Saucedemo;

import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import patterns.Saucedemo.PageFactory_CartPage;
import patterns.Saucedemo.ValueObject.CheckOutPage_ValueObject;
import patterns.Saucedemo.ValueObject.CheckOutPage_VObject;

public class ValueObject_CheckOutPage_Test extends BaseTest {
    CheckOutPage_VObject valueObject_checkOutPage;
    CheckOutPage_ValueObject checkOutPage_data;
    PageFactory_CartPage pageFactory_cartPage;

    @BeforeClass
    public void precondition() {
        valueObject_checkOutPage = new CheckOutPage_VObject(driver);
        checkOutPage_data = new CheckOutPage_ValueObject("FirstName", "LastName", 11111);
        pageFactory_cartPage = new PageFactory_CartPage(driver);
    }

    @Test
    public void registrationOnCheckOutPage_Test() {
        pageFactory_cartPage.addProducts()
                .moveToCart();
        valueObject_checkOutPage.moveToCheckOutPage()
                .entreRegistrationData(checkOutPage_data)
                .verifyOverviewPage();

    }

}
