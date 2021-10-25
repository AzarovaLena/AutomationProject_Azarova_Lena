package pageObject.moodPanda_Selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class FAQs {
    SelenideElement FAQsBtn = $(byXpath("//a[contains(text(),'FAQs')]"));
    SelenideElement lastElementOnPage =$(byXpath("//h3[contains(text(),'I have')]"));

    public FAQs clickFAQSBtn(){
        FAQsBtn.click();
        return this;
    }
    public FAQs scrollToElement(){
        actions().moveToElement(lastElementOnPage);
        lastElementOnPage.shouldBe(visible);
        return this;
    }
}
