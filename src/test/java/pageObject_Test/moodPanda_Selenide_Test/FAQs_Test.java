package pageObject_Test.moodPanda_Selenide_Test;

import pageObject.moodPanda_Selenide.FAQs;
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

