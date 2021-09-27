package Lecture_12_13;

import driver.BaseTest;
import PageObject.Herokuapp.DynamicControls;
import PageObject.Herokuapp.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class Task_12_13_dynamicControls extends BaseTest {
    DynamicControls dynamicControls;
    HomePage homePage;

    @BeforeClass
    public void precondition() {
        dynamicControls = new DynamicControls(driver);
        homePage = new HomePage(driver);
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
