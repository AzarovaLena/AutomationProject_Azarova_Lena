package pageObject_Test.booking_Test.steps;

import driver.BaseTestSelenide;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.booking.HotelPage;
import pageObject.booking.SearchPage;


public class Booking_Test extends BaseTestSelenide {
    @Given("the booking page")
    public void openPage(){
        get(SearchPage.class)
                .checkHeaderTitle();
    }
    @When("enter hotel in the search line and Click search button")
    public void searchHotel() {
        get(SearchPage.class)
                .searchHotel("Crillon")
                .clickSearchBtn();
    }
    @Then("the hotel is displayed with correct name and Exceptional rate")
    public void hotelResults(){
        get(HotelPage.class)
                .verifyHotelOnPage("Crillon")
                .checkHotelOnRate();

    }
}
