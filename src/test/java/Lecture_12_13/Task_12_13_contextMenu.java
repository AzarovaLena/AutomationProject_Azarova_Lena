package Lecture_12_13;

import driver.BaseTest;
import PageObject.herokuapp.ContextMenu;
import PageObject.herokuapp.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.herokuapp.HomePageLinksEnum.CONTEXT_MENU;

public class Task_12_13_contextMenu extends BaseTest {
    ContextMenu contextMenu;
    HomePage homePage;

    @BeforeClass
    public void precondition(){
        contextMenu = new ContextMenu(driver);
        homePage = new HomePage(driver);
        homePage.clickLink(CONTEXT_MENU);
    }
    @Test
    public void contextMenu_Test(){
        contextMenu.verifyPageTitle()
                .verifyAlertText()
                .pause(4);
    }

}
