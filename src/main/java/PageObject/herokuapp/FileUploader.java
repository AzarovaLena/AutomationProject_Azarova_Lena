package PageObject.herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FileUploader extends BasePage {
     private By fileUploadBtn = By.id("file-upload");
     private By title = By.tagName("h3");
     private By fileSubmitBtn = By.id("file-submit");
     private By uploadedFile = By.id("uploaded-files");
    private String userDir = System.getProperty("user.dir");


    public FileUploader (WebDriver driver){
        super(driver);
    }

    public FileUploader verifyPageTitle(String title) {
        Assert.assertEquals(getElementText(this.title), title);
        return this;
    }
    public FileUploader uploadFile(){
        driver.findElement(fileUploadBtn).sendKeys(userDir + properties.getProperty("filePath"));
        return  this;
    }
    public FileUploader clickFileSubmit(){
        click(fileSubmitBtn);
        return this;
    }
    public FileUploader verifyFileUploaded(String text){
        Assert.assertEquals(getElementText(uploadedFile), text);
        return this;
    }
}
