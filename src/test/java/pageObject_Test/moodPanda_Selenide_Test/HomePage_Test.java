package pageObject_Test.moodPanda_Selenide_Test;

import pageObject.moodPanda_Selenide.HomePage;
import driver.BaseTestSelenide;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class HomePage_Test extends BaseTestSelenide {

    @Test
    @Description("checking the display of elements on the main page and tabbed navigation")
    public void checkHomePage_Test(){
        get(HomePage.class)
                .checkBrandName()
                .clickTabs()
                .clickScrollDown();
    }
    @AfterMethod
    public void postconditions (){
        closeWebDriver();
    }
}
