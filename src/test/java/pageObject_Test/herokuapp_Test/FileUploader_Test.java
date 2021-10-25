package pageObject_Test.herokuapp_Test;

import pageObject.herokuapp.FileUploader;
import pageObject.herokuapp.HomePage;
import driver.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static pageObject.herokuapp.HomePageLinksEnum.FILE_UPLOADER;

public class FileUploader_Test extends BaseTest {
    HomePage homePage;
    FileUploader fileUploader;

    @BeforeClass
    public void precondition() {
        fileUploader = new FileUploader();
        homePage = new HomePage();
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
