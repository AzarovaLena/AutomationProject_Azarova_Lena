package PageObject.MoodPanda_Selenide;

import com.codeborne.selenide.SelenideElement;

public class BasePageSelenide {

    protected void entreData(SelenideElement element, String expectedData){
        element.click();
        element.clear();
        element.setValue(expectedData);
    }
}
