package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AllVeterinariansPage {

    public List<WebElement> veterinariansList;
    public List<WebElement> deleteVet;

    public AllVeterinariansPage (WebDriver webDriver) {
        veterinariansList=webDriver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        deleteVet=webDriver.findElements(By.xpath("//table/tbody/tr/td[3]/button[2]"));
    }

    public boolean veterinarianListStr(String veterinarianName){
        List<String> textVet= new ArrayList<String>();
        for(WebElement we:veterinariansList){
            textVet.add(we.getText());
        }
        for(String vet : textVet) {
            if(vet.equals(veterinarianName)){
                return true;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteVet(String vetNameDelete){
        for (int i=0;i<veterinariansList.size();i++){
            String vetDelete=veterinariansList.get(i).getText();
            if(vetNameDelete.equals(vetDelete)){
                deleteVet.get(i).click();
                break;
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
