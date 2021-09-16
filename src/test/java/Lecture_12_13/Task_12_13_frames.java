package Lecture_12_13;

import PageObject.herokuapp.Frames;
import PageObject.herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.herokuapp.HomePageLinksEnum.FRAMES;

public class Task_12_13_frames extends BaseTest {
    HomePage homePage;
    Frames frames;

    @BeforeClass
    public void precondition() {
        frames = new Frames(driver);
        homePage = new HomePage(driver);
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
