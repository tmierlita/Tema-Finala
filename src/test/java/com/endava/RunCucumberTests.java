package com.endava;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources",
        glue = "com/endava/stepdefs",
        plugin = "pretty"
)

public class RunCucumberTests extends AbstractTestNGCucumberTests {
}
