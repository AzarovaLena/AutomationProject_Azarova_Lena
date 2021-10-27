package pageObject.booking;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    SelenideElement headerTitle = $("[class*='bui-header--logo-large']");
    SelenideElement searchLine = $(By.id("ss"));
    SelenideElement searchBtn = $("[data-sb-id='main']");
    

    public SearchPage checkHeaderTitle() {
        headerTitle.shouldBe(Condition.visible);
        return this;
    }

    public SearchPage searchHotel(String text) {

        searchLine.click();
        searchLine.setValue(text);

        return this;
    }

    public SearchPage clickSearchBtn() {
        searchBtn.click();
        return this;
    }

}
