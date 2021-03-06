package pageObject.herokuapp;

import pageObject.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    private By title = By.tagName ("h1");
    private By subTitle = By.tagName ("h2");
    private By getLink (HomePageLinksEnum homePageLinksEnum){
        return By.linkText(homePageLinksEnum.getLinkText());
    }

    public HomePage openPage (){
        open();
        return this;
    }
    public HomePage clickLink (HomePageLinksEnum homePageLinksEnum){
        click(getLink(homePageLinksEnum));
        return this;
    }
    public HomePage verifyHomePage(){
        displayElements(title, subTitle);
        for(HomePageLinksEnum homePageLinksEnum : HomePageLinksEnum.values()){
            displayElements(getLink(homePageLinksEnum));
        }
        return this;
    }

}
