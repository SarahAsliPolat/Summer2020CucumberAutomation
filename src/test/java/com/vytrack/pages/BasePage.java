package com.vytrack.pages;

import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    @FindBy(className = "oro-subtitle")
    protected WebElement pageSubTitle;


    public BasePage() { //super class for all classes
        PageFactory.initElements(Driver.getDriver(), this);//in order to be able use @FindBy annotation

    }

    public String getPageSubTitleText() {
        return pageSubTitle.getText();
    }


    public void navigateTo(String tab, String module) {//methods for navigation in vytrack
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        String tabXpath = "//*[contains(text(),'" + tab + "')and@class='title title-level-1']";
        //you can use this xpath to navigate in the page modules by changing the tab name to the module you want to navigate and level number

        //xpath for modules like vehicles, vehicles odometer etc.. modules inside vehicle dropdown
        String moduleXpath="//*[contains(text(),'"+module+"')and@class='title title-level-2']";

        WebElement tabElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tabXpath)));
         wait.until(ExpectedConditions.elementToBeClickable(tabElement)).click();

         WebElement moduleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleXpath)));
         wait.until(ExpectedConditions.elementToBeClickable(moduleElement)).click();
    }
    }
