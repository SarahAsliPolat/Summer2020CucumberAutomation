package com.vytrack.pages;

import com.vytrack.utils.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //when you have a base page you only need to call the methods in step definitions. keep web elements private

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password; //why private: to prevent using web element directly in step definitions.helps to prevent duplication and keeps step definitions clean

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessage(){
        return warningMessage.getText().trim();
    }

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }


    public void login() { //reading username and password from conf prop
        String usernameValue = ConfigurationReader.getProperty("storemanager.username");
        String passwordValue = ConfigurationReader.getProperty("password");
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    //another method that accepts different roles
    public void login(String role) {

        String usernameValue = "";
        String passwordValue = ConfigurationReader.getProperty("password");

        if(role.equalsIgnoreCase("sales manager")){
            usernameValue=ConfigurationReader.getProperty("salesmanager.username");
        }else if(role.equalsIgnoreCase("driver")){
            usernameValue=ConfigurationReader.getProperty("driver.username");
        }else{
            usernameValue = ConfigurationReader.getProperty("storemanager.username");

        }
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }
}