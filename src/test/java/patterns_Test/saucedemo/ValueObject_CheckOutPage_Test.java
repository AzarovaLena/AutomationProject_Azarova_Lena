package patterns_Test.saucedemo;

import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import patterns.saucedemo.PageFactory_CartPage;
import patterns.saucedemo.valueObject.CheckOutPage_ValueObject;
import patterns.saucedemo.valueObject.CheckOutPage_VObject;

public class ValueObject_CheckOutPage_Test extends BaseTest {
    CheckOutPage_VObject valueObject_checkOutPage;
    CheckOutPage_ValueObject checkOutPage_data;
    PageFactory_CartPage pageFactory_cartPage;

    @BeforeClass
    public void precondition() {
        valueObject_checkOutPage = new CheckOutPage_VObject();
        checkOutPage_data = new CheckOutPage_ValueObject();
        checkOutPage_data.setFirstName("FirstName");
        checkOutPage_data.setLastName("LastName");
        checkOutPage_data.setZipCode("11111");
        pageFactory_cartPage = new PageFactory_CartPage();
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
