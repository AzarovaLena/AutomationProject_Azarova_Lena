package Lecture_12_13;

import driver.BaseTest;
import PageObject.Herokuapp.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_12_13_homePage extends BaseTest {
    HomePage homePage;
    @BeforeClass
    public void precondition(){
        homePage = new HomePage(driver);
    }
    @Test
    public void verifyHomePage_Test(){
        homePage.openPage()
                .verifyHomePage();
    }

}
