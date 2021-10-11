package MoodPanda_Selenide_Test;

import PageObject.MoodPanda_Selenide.LoginPage;
import PageObject.MoodPanda_Selenide.RegistrationForm;
import driver.BaseTestSelenide;
import jdk.jfr.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.back;

public class RegistrationForm_Test extends BaseTestSelenide {
    @BeforeTest
    public void preconditions() {
        get(LoginPage.class)
                .clickLoginTab();
        get(RegistrationForm.class)
                .clickCreateForm();
    }

    @DataProvider(name = "data for registration form")
    public Object[][] inputDataForRegistrationForm() {
        return new Object[][]{
                {"user", " ", "user@user.com", "111", "111", "Error: Please complete all fields correctly"},
                {"user", "u", "user@user.com", "111", "111", ""},
                {"user", "u", "user123@user.com", "123", "123", "Error: This email is already registed with MoodPanda"}
        };
    }

    @Test(dataProvider = "data for registration form")
    @Description("checking registration form")
    public void checkRegistrationForm_Test(String firstName, String surname, String email, String password, String passwordConfirm, String expectedErrorText) {
        String errorText ="Error: Please complete all fields correctly";
        get(RegistrationForm.class)
                .entreFirstName(firstName)
                .entreSurname(surname)
                .selectGender()
                .selectYearOfBirth()
                .entreTextBoxEmail(email)
                .entreTextBoxPassword(password)
                .entreTextBoxPasswordConfirm(passwordConfirm)
                .clickLoginRegistrationForm();
        if (expectedErrorText.isEmpty()) {
            back();
        }
        else if (expectedErrorText.equals(errorText)) {
            get(RegistrationForm.class).checkErrorMassageInRegistrationForm(expectedErrorText);
        } else {
            get(RegistrationForm.class).checkMassageExistsInRegistrationForm(expectedErrorText);
        }
    }
}
