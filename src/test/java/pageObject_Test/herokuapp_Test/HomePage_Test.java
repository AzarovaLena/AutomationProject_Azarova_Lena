package pageObject_Test.herokuapp_Test;

import driver.BaseTest;
import pageObject.herokuapp.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest {
    HomePage homePage;
    @BeforeClass
    public void precondition(){
        homePage = new HomePage();
    }
    @Test
    public void verifyHomePage_Test(){
        homePage.openPage()
                .verifyHomePage();
    }

}
