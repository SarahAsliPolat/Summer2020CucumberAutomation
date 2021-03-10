package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginStepDefinitions {
    WebDriver driver;
    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing")
    public void user_is_on_the_landing() {
        Driver.getDriver().get("http://qa1.vytrack.com");

    }

    @When("user logs in")
    public void user_logs_in() {
        loginPage.login();


    }

    @Then("user should see dashboard page")
    public void user_should_see_dashboard_page() {

        String expected = "Dashboard";
        String actual = loginPage.getPageSubTitleText();

        Assert.assertEquals("title is not correct!", expected, actual);
        System.out.println("i see the dashboard");
        Driver.closeDriver();
    }

    @When("user logs in as a {string}")//it will use the method with role''{string} represents the role
    public void user_logs_in_as_a(String string) {
        loginPage.login(string);
    }


    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {//in feature file, the word in between" " are assigned to the strings. so for this specific one the first {string}' value is "store manager" and the second one is "wrong password". it will be used for login
        loginPage.login(string, string2);
    }


    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualResult=loginPage.getWarningMessage();
        Assert.assertEquals(expected,actualResult);
    }

}

