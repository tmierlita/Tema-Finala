package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    public WebElement welcomeMsg;
    public WebElement headerMsg;
    public WebElement image;

    public HomePage (WebDriver webDriver){

        welcomeMsg=webDriver.findElement(By.xpath("//app-welcome/h1"));
        headerMsg=webDriver.findElement(By.xpath("//div/h2"));
        image=webDriver.findElement(By.className("img-responsive"));

    }

    public boolean welcomeDisplayed(){
        return welcomeMsg.isDisplayed();
    }

    public String headerDisplayed(){
        return headerMsg.getText();
    }

    public boolean imageDisplayed(){
        return image.isDisplayed();
    }
}
