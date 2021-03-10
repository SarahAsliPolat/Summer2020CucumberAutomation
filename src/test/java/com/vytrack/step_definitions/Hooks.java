package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.concurrent.TimeUnit;

public class Hooks { //hooks class triggerd based on tags not class name or their location

    @Before
    public void setup(){
        System.out.println("starting automation");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Before("@db")
    public void dbSetup(){ //this hook will run only before scenarios with a tag @db //database test
        System.out.println("connecting to database");
    }
    @After("@db")
    public void dbTearDown(){
        System.out.println("disconnecting from database");
    }

    @After
    public void tearDown(){ //hook after: runs automatically after every test
        Driver.closeDriver();
        System.out.println("End of test execution(*_*)");
    }
}
