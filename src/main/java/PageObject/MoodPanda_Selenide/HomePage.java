package pageObject.moodPanda_Selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    SelenideElement brandName = $(".brand-name.hidden-xs.hidden-height-670");
    SelenideElement scrollDownBtn= $("[class*='fa-angle-down']");
    SelenideElement pageElement= $(byXpath("//p[contains(text(),'Wonderful')]"));
    SelenideElement iosBtn= $(byText("iOS"));
    SelenideElement iosPageImg= $(byId("ember106"));
    SelenideElement AndroidBtn= $(byText("Android"));
    SelenideElement AndroidPageName= $(byXpath("//h1/span[text()='MoodPanda']"));

    public HomePage checkBrandName () {
        brandName.shouldHave(exactText("MoodPanda"));
        return this;
    }
    public HomePage clickTabs(){
        iosBtn.click();
        iosPageImg.shouldBe(visible);
        back();
        AndroidBtn.click();
        AndroidPageName.shouldHave(exactText("MoodPanda"));
        back();
        return this;
    }
    public HomePage clickScrollDown () {
        scrollDownBtn.click();
        pageElement.shouldBe(visible);
        return this;
    }

}
