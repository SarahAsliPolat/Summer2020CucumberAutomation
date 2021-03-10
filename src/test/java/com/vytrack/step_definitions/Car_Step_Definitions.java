package com.vytrack.step_definitions;

import com.vytrack.pages.CreateCarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class Car_Step_Definitions {
    CreateCarPage createCarPage =new CreateCarPage();

    @Given("user clicks on create car button")
    public void user_clicks_on_create_car_button() {
        createCarPage.clickOnCreateCar();

    }

    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String, String> dataTable) {//in order to be able insert the data we changed the parameter to Map.We chose String for both because we will use send.Keys method.




    }

}
