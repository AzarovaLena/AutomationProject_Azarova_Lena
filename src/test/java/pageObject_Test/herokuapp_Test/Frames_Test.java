package pageObject_Test.herokuapp_Test;

import pageObject.herokuapp.Frames;
import pageObject.herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static pageObject.herokuapp.HomePageLinksEnum.FRAMES;

public class Frames_Test extends BaseTest {
    HomePage homePage;
    Frames frames;

    @BeforeClass
    public void precondition() {
        frames = new Frames();
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
