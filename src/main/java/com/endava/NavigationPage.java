package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage {

    public WebElement homeButton;
    public WebElement ownerButton;
    public WebElement addOwnerButton;
    public WebElement veterinariansButton;
    public WebElement addVeterinariansButton;
    public WebElement petTypesButton;
    public WebElement specialtiesButton;

    public NavigationPage(WebDriver webDriver){
        homeButton=webDriver.findElement(By.linkText("HOME"));
        ownerButton=webDriver.findElement(By.xpath("//a[text()='Owners']"));
        veterinariansButton=webDriver.findElement(By.xpath("//a[text()='Veterinarians']"));
        petTypesButton=webDriver.findElement(By.linkText("PET TYPES"));
        specialtiesButton=webDriver.findElement(By.linkText("SPECIALTIES"));
    }

    public void clickOwnerAdd(WebDriver webDriver){
        ownerButton.click();
        addOwnerButton=webDriver.findElement(By.linkText("ADD NEW"));
        addOwnerButton.click();
    }
    public void clickVeterinariansAdd(WebDriver webDriver){
        veterinariansButton.click();
        addVeterinariansButton=webDriver.findElement(By.linkText("ADD NEW"));
        addVeterinariansButton.click();
    }

    public void clickPetTypes(){
        petTypesButton.click();
    }
}
