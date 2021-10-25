package pageObject_Test.herokuapp_Test;

import driver.BaseTest;
import pageObject.herokuapp.ContextMenu;
import pageObject.herokuapp.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static pageObject.herokuapp.HomePageLinksEnum.CONTEXT_MENU;

public class ContextMenu_Test extends BaseTest {
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
