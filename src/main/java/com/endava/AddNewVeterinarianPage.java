package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewVeterinarianPage {

    public WebElement FirstName;
    public WebElement Lastname;
    public WebElement SaveVet;

    public AddNewVeterinarianPage (WebDriver webDriver){
        FirstName=webDriver.findElement(By.id("firstName"));
        Lastname=webDriver.findElement(By.id("lastName"));
        SaveVet=webDriver.findElement(By.id("specialties"));
    }

    public void insert(String firstname, String lastname){
        FirstName.sendKeys(firstname);
        Lastname.sendKeys(lastname);
        SaveVet.submit();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
