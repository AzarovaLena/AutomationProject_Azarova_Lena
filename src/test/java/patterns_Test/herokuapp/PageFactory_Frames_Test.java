package patterns_Test.herokuapp;

import pageObject.herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import patterns.herokuapp.PageFactory_Frames;

import static pageObject.herokuapp.HomePageLinksEnum.FRAMES;

public class PageFactory_Frames_Test extends BaseTest {
    HomePage homePage;
    PageFactory_Frames frames;

    @BeforeClass
    public void precondition() {
        frames = new PageFactory_Frames();
        homePage = new HomePage();
        homePage.clickLink(FRAMES);
    }
    @Test
    public void frames_Test(){
        frames.verifyPageTitle("Frames")
                .clickFrameLink("iFrame")
                .verifyPageTitle("An iFrame containing the TinyMCE WYSIWYG Editor")
                .verifyFrameText("Your content goes here.");
    }
}
