package com.endava;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBaseClass {

    public WebDriver webdriver;

    @Before

    public void initialize(){
        webdriver= new ChromeDriver();
        webdriver.get("http://bhdtest.endava.com/petclinic/welcome");
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After

    public void tearDown(){webdriver.quit();}
}
