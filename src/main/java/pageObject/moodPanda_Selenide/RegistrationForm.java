package pageObject.moodPanda_Selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationForm extends BasePageSelenide{
    SelenideElement createFormBtn = $("#ContentPlaceHolderContent_HyperLinkRegister");
    SelenideElement firstName = $("#ContentPlaceHolderContent_TextBoxFirstName");
    SelenideElement surname = $("#ContentPlaceHolderContent_TextBoxSurname");
    SelenideElement gender = $("#ContentPlaceHolderContent_DropDownListGender");
    SelenideElement YearOfBirth = $("#ContentPlaceHolderContent_DropDownListYearOfBirth");
    SelenideElement textBoxEmail = $("#ContentPlaceHolderContent_TextBoxEmail");
    SelenideElement textBoxPassword = $("#ContentPlaceHolderContent_TextBoxPassword");
    SelenideElement textBoxPasswordConfirm = $("#ContentPlaceHolderContent_TextBoxPasswordConfirm");
    SelenideElement loginRegistrationForm = $("#ContentPlaceHolderContent_ButtonLogin");
    SelenideElement errorMassageInRegistrationForm = $("#ContentPlaceHolderContent_MessageError");
    SelenideElement MessageExistsInRegistrationForm =$("#ContentPlaceHolderContent_MessageExists");

    public RegistrationForm clickCreateForm() {
        createFormBtn.click();
        return this;
    }

    public RegistrationForm entreFirstName(String firstName) {
        entreData(this.firstName, firstName);
        return this;
    }

    public RegistrationForm entreSurname(String surname) {
        entreData(this.surname, surname);
        return this;
    }

    public RegistrationForm selectGender() {
        gender.selectOption(1);
        return this;
    }

    public RegistrationForm selectYearOfBirth() {
        YearOfBirth.selectOption(10);
        return this;
    }

    public RegistrationForm entreTextBoxEmail(String email) {
        entreData(textBoxEmail, email);
        return this;
    }

    public RegistrationForm entreTextBoxPassword(String password) {
        entreData(textBoxPassword, password);
        return this;
    }

    public RegistrationForm entreTextBoxPasswordConfirm(String passwordConfirm) {
        entreData(textBoxPasswordConfirm, passwordConfirm);
        return this;
    }

    public RegistrationForm clickLoginRegistrationForm() {
        loginRegistrationForm.click();
        return this;
    }

    public RegistrationForm checkErrorMassageInRegistrationForm(String expectedMessage) {
        errorMassageInRegistrationForm.shouldHave(matchText(expectedMessage));
        return this;
    }
    public RegistrationForm checkMassageExistsInRegistrationForm(String expectedMessage) {
        MessageExistsInRegistrationForm.shouldHave(matchText(expectedMessage));
        return this;
    }

}

