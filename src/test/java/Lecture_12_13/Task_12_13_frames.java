package Lecture_12_13;

import PageObject.Herokuapp.Frames;
import PageObject.Herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.FRAMES;

public class Task_12_13_frames extends BaseTest {
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
