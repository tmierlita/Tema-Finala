package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PetTypesPage {

    public WebElement addPet;
    public WebElement homeScr;
    public List<WebElement> petTypes;
    public List<WebElement> editPet;
    public List<WebElement> deletePet;
    public WebElement namePet;
    public WebElement savePet;

    public PetTypesPage(WebDriver webDriver) {
        addPet = webDriver.findElement(By.xpath("//button[contains(text(),'Add')]"));
        homeScr = webDriver.findElement(By.xpath("//button[contains(text(),'Home')]"));
        petTypes = webDriver.findElements(By.xpath("//tbody/tr/td[1]"));
        editPet = webDriver.findElements(By.xpath("//tbody/tr/td[2]/button[1]"));
        deletePet = webDriver.findElements(By.xpath("//tbody/tr/td[2]/button[2]"));
    }

    public void clickAddPet(WebDriver webDriver, String petname) {
        addPet.click();
        namePet = webDriver.findElement(By.xpath("//input[@id='name']"));
        savePet = webDriver.findElement(By.xpath("//button[@type='submit']"));
        namePet.sendKeys(petname);
        savePet.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkPetAdd(String petType, WebDriver webDriver) {
        JavascriptExecutor e = (JavascriptExecutor) webDriver;
        for (int i = 0; i < petTypes.size(); i++) {
            String petTypeName = (String) e.executeScript("return document.getElementById('" + i + "').value");
            if (petTypeName.equals(petType)) {
                return true;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException g) {
            g.printStackTrace();
        }
        return false;
    }

    public void editPet(String petType, WebDriver webDriver) {
        JavascriptExecutor e = (JavascriptExecutor) webDriver;
        for (int i = 0; i < petTypes.size(); i++) {
            String petTypeName = (String) e.executeScript("return document.getElementById('" + i + "').value");
            if (petTypeName.equals(petType)) {
                editPet.get(i).click();
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public void deletePet(String petType, WebDriver webDriver) {
        JavascriptExecutor e = (JavascriptExecutor) webDriver;
        for (int i = 0; i < petTypes.size(); i++) {
            String petTypeName = (String) e.executeScript("return document.getElementById('" + i + "').value");
            if (petTypeName.equals(petType)) {
                deletePet.get(i).click();
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
