package Lecture_14_Patterns.Herokuapp;

import PageObject.Herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import patterns.Herokuapp.PageFactory_Frames;

import static PageObject.Herokuapp.HomePageLinksEnum.FRAMES;

public class PageFactory_Frames_Test extends BaseTest {
    HomePage homePage;
    PageFactory_Frames frames;

    @BeforeClass
    public void precondition() {
        frames = new PageFactory_Frames(driver);
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
