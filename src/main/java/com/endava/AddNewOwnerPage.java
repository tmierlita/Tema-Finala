package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewOwnerPage {

        public WebElement FirstName;
        public WebElement Lastname;
        public WebElement Address;
        public WebElement City;
        public WebElement Telephone;
        public WebElement AddOwnerButton;

        public AddNewOwnerPage(WebDriver webDriver){
            FirstName=webDriver.findElement(By.id("firstName"));
            Lastname=webDriver.findElement(By.id("lastName"));
            Address=webDriver.findElement(By.id("address"));
            City=webDriver.findElement(By.id("city"));
            Telephone=webDriver.findElement(By.id("telephone"));
        }

        public void insert(String firstname, String lastname, String address, String city, String telephone){
            FirstName.sendKeys(firstname);
            Lastname.sendKeys(lastname);
            Address.sendKeys(address);
            City.sendKeys(city);
            Telephone.sendKeys(telephone);
        }

        public void submitAddOwner(WebDriver webDriver){
            AddOwnerButton=webDriver.findElement(By.xpath("//button[@type='submit']"));
            AddOwnerButton.submit();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
