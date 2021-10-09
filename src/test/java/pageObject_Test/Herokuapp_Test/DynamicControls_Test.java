package pageObject_Test.Herokuapp_Test;

import driver.BaseTest;
import pageObject.herokuapp.DynamicControls;
import pageObject.herokuapp.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static pageObject.herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class DynamicControls_Test extends BaseTest {
    DynamicControls dynamicControls;
    HomePage homePage;

    @BeforeClass
    public void precondition() {
        dynamicControls = new DynamicControls();
        homePage = new HomePage();
        homePage.clickLink(DYNAMIC_CONTROLS);
    }

    @Test
    public void dynamicControls_Test() {
        dynamicControls.verifyPageTitle()
                .checkboxIsDisplayed()
                .clickRemoveBtn()
                .verifyElementText("It's gone!")
                .checkboxNotDisplayed()
                .verifyInputDisabled()
                .clickInputEnableBtn()
                .verifyEnableText("It's enabled!")
                .verifyInputEnabled();
    }
}
