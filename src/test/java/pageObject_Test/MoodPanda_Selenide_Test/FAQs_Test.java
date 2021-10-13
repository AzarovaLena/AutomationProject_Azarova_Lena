package pageObject_Test.MoodPanda_Selenide_Test;

import PageObject.MoodPanda_Selenide.FAQs;
import driver.BaseTestSelenide;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class FAQs_Test extends BaseTestSelenide{

        @Test
        @Description("")
        public void CheckFAQsPage(){
            get(FAQs.class)
                    .clickFAQSBtn()
                    .scrollToElement();
        }
    }

