package Lecture_12_13;

import driver.BaseTest;
import PageObject.Herokuapp.ContextMenu;
import PageObject.Herokuapp.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.CONTEXT_MENU;

public class Task_12_13_contextMenu extends BaseTest {
    ContextMenu contextMenu;
    HomePage homePage;

    @BeforeClass
    public void precondition(){
        contextMenu = new ContextMenu();
        homePage = new HomePage();
        homePage.clickLink(CONTEXT_MENU);
    }
    @Test
    public void contextMenu_Test(){
        contextMenu.verifyPageTitle()
                .verifyAlertText()
                .pause(4);
    }

}
