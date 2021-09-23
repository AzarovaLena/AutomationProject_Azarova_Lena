package Lecture_12_13;

import PageObject.Herokuapp.FileUploader;
import PageObject.Herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.FILE_UPLOADER;

public class Task_12_13_fileUploader extends BaseTest {
    HomePage homePage;
    FileUploader fileUploader;

    @BeforeClass
    public void precondition() {
        fileUploader = new FileUploader(driver);
        homePage = new HomePage(driver);
        homePage.clickLink(FILE_UPLOADER);

    }
    @Test
    public void fileUploader_Test(){
        fileUploader.verifyPageTitle("File Uploader")
                .uploadFile()
                .clickFileSubmit()
                .verifyFileUploaded("Download-File-iOS-10-Safari-Guide-Skachat-00-1280x720.jpg");
    }

}
