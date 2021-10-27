package pageObject.booking;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HotelPage {

    SelenideElement hotelTitle = $("[data-testid='property-card']:nth-child(2) div[data-testid='title']");
    SelenideElement hotelTRate = $(byXpath("//div[text()='Exceptional']"));

    public HotelPage verifyHotelOnPage(String text) {
        hotelTitle.shouldBe(Condition.visible);
        hotelTitle.shouldHave(matchText(text));
        return this;
    }
    public HotelPage checkHotelOnRate () {
        hotelTRate.shouldHave(matchText("Exceptional"));
        return this;
    }



}
