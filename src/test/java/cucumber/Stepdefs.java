package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Stepdefs {

    private String today;
    private String actualAnswer;
    private long fridayCount;

    @Given("today is Sunday")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @When("I ask whether it's Friday yet")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }

    @Given("today is Friday")
    public void todayIsFriday() {
        today = "Friday";
    }

    @Given("the following days:")
    public void theFollowingDays(List<String> days) {
        fridayCount = IsItFriday.countFridays(days);
    }

    @Then("tell me there is {int} Fridays")
    public void tellMeThereIsFridays(int expectedFridayCount) {
        assertEquals(expectedFridayCount,fridayCount);
    }

    @Given("today is {string}")
    public void todayIs(String today) {
        this.today = today;
    }

    @Given("today is Monday")
    public void todayIsMonday() {
        this.today = "Monday";
    }

    @When("I ask whether it's Monday")
    public void iAskWhetherItSMonday() {
        this.actualAnswer = IsItMonday.isItMonday(today);
    }

}
