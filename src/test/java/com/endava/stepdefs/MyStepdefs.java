package com.endava.stepdefs;

import com.endava.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class MyStepdefs extends TestBaseClass {

    public HomePage homePage;
    public NavigationPage navPage;
    public AddNewOwnerPage addOwnerPage;
    public AllOwnersPage allOwnersPage;
    public AddNewVeterinarianPage addNewVeterinarianPage;
    public AllVeterinariansPage allVeterinariansPage;
    public PetTypesPage petTypesPage;
    public EditPetPage editPetPage;

    @Given("^I have access to the PetClinic platform$")
    public void iHaveAccessToThePetClinicPlatform() throws Throwable {
        initialize();
    }

    @When("^I access the homepage$")
    public void iAccessTheHomepage() throws Throwable {
        homePage=new HomePage(webdriver);
    }

    @Then("^The Welcome header will be displayed$")
    public void theWelcomeHeaderWillBeDisplayed() throws Throwable {
        Assert.assertTrue(homePage.welcomeDisplayed());
    }

    @And("^The welcome message \"([^\"]*)\" will be displayed$")
    public void theWelcomeMessageWillBeDisplayed(String message) throws Throwable {
        Assert.assertEquals(message,homePage.headerDisplayed());
    }

    @And("^The welcome image will be displayed$")
    public void theWelcomeImageWillBeDisplayed() throws Throwable {
        Assert.assertTrue(homePage.imageDisplayed());
        tearDown();
    }

    @And("^I have access to create a new owner$")
    public void iHaveAccessToCreateANewOwner() throws Throwable {
        navPage = new NavigationPage(webdriver);
        navPage.clickOwnerAdd(webdriver);
    }

    @And("^I create a new owner firstname \"([^\"]*)\", lastname \"([^\"]*)\", address \"([^\"]*)\", city \"([^\"]*)\", telephone \"([^\"]*)\"$")
    public void iCreateANewOwnerFirstnameLastnameAddressCityTelephone(String firstname, String lastname, String address, String city, String telephone) throws Throwable {
        addOwnerPage = new AddNewOwnerPage(webdriver);
        addOwnerPage.insert(firstname,lastname,address,city,telephone);
        addOwnerPage.submitAddOwner(webdriver);
    }

    @When("^I look in the All Owners page$")
    public void iLookInTheAllOwnersPage() throws Throwable {
        allOwnersPage = new AllOwnersPage(webdriver);
    }

    @Then("^The owner \"([^\"]*)\" will be displayed$")
    public void theOwnerWillBeDisplayed(String ownerName) throws Throwable {
        Assert.assertTrue(allOwnersPage.ownerListStr(ownerName));
        tearDown();
    }

    @And("^I have access to create new veterinarian$")
    public void iHaveAccessToCreateNewVeterinarian() throws Throwable {
        navPage = new NavigationPage(webdriver);
        navPage.clickVeterinariansAdd(webdriver);
    }

    @And("^I create a new veterinarian firstname \"([^\"]*)\", lastname \"([^\"]*)\"$")
    public void iCreateANewVeterinarianFirstnameLastname(String firstname, String lastname) throws Throwable {
        addNewVeterinarianPage = new AddNewVeterinarianPage(webdriver);
        addNewVeterinarianPage.insert(firstname,lastname);
    }

    @When("^I look in the All Veterinarians page$")
    public void iLookInTheAllVeterinariansPage() throws Throwable {
        allVeterinariansPage = new AllVeterinariansPage(webdriver);
    }

    @Then("^The veterinarian \"([^\"]*)\" will be displayed$")
    public void theVeterinarianWillBeDisplayed(String vetName) throws Throwable {
        Assert.assertTrue(allVeterinariansPage.veterinarianListStr(vetName));
        tearDown();
    }

    @And("^I delete the new added veterinarian \"([^\"]*)\"$")
    public void iDeleteTheNewAddedVeterinarian(String vetName) throws Throwable {
        allVeterinariansPage = new AllVeterinariansPage(webdriver);
        allVeterinariansPage.deleteVet(vetName);
    }

    @Then("^The veterinarian \"([^\"]*)\" will not be displayed$")
    public void theWelcomeMessageWillNotBeDisplayed(String vetName) throws Throwable {
        allVeterinariansPage = new AllVeterinariansPage(webdriver);
        Assert.assertFalse(allVeterinariansPage.veterinarianListStr(vetName));
        tearDown();
    }

    @And("^I have access to create a new pet type$")
    public void iHaveAccessToCreateANewPetType() throws Throwable {
        navPage = new NavigationPage(webdriver);
        navPage.clickPetTypes();
    }

    @And("^I create a new pet type \"([^\"]*)\"$")
    public void iCreateANewPetType(String petname) throws Throwable {
        petTypesPage = new PetTypesPage(webdriver);
        petTypesPage.clickAddPet(webdriver,petname);
    }

    @When("^I look in the Pet Types page$")
    public void iLookInThePetTypesPage() throws Throwable {
        petTypesPage = new PetTypesPage(webdriver);
    }

    @Then("^The pet type \"([^\"]*)\" will be displayed$")
    public void thePetTypeWillBeDisplayed(String petname) throws Throwable {
        Assert.assertTrue(petTypesPage.checkPetAdd(petname,webdriver));
        tearDown();
    }

    @And("^I edit the new added pet from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void iEditTheNewAddedPetFromTo(String petname, String newPetName) throws Throwable {
        petTypesPage = new PetTypesPage(webdriver);
        petTypesPage.editPet(petname,webdriver);
        editPetPage = new EditPetPage(webdriver);
        editPetPage.editPet(newPetName);
    }

    @And("^I delete the new pet type \"([^\"]*)\"$")
    public void iDeleteTheNewPetType(String petname) throws Throwable {
        petTypesPage = new PetTypesPage(webdriver);
        petTypesPage.deletePet(petname,webdriver);
    }

    @Then("^The pet type \"([^\"]*)\" will not be displayed$")
    public void thePetTypeWillNotBeDisplayed(String petname) throws Throwable {
        Assert.assertFalse(petTypesPage.checkPetAdd(petname,webdriver));
        tearDown();
    }
}
