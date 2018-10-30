package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPetPage {
    public WebElement petName;
    public WebElement updateButton;

    public EditPetPage(WebDriver webDriver){
        petName=webDriver.findElement(By.xpath("//input[@id='name']"));
        updateButton=webDriver.findElement(By.xpath("//button[@type='submit']"));
    }

    public void editPet (String newPetName){
        petName.clear();
        petName.sendKeys(newPetName);
        updateButton.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
