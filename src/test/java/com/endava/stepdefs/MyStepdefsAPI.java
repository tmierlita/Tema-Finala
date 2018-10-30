package com.endava.stepdefs;

import com.endava.UserCredentials;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class MyStepdefsAPI {

    private RequestSpecification request;
    private Response response;
    private UserCredentials users;

    @Given("^I have access to perform POST request$")
    public void iHaveAccessToPerformPOSTRequest() throws Throwable {
        request=given().baseUri("http://bhdtest.endava.com:8080/petclinic/api").
                auth().preemptive().basic("admin","admin").contentType(ContentType.JSON);
    }

    @Then("^I will have status code \"([^\"]*)\"$")
    public void iWillHaveStatusCode(int statusCode) throws Throwable {
        response.then().statusCode(statusCode);
    }

    @When("^I will perform POST request to \"([^\"]*)\" to create user with \"([^\"]*)\" rights$")
    public void iWillPerformPOSTRequestToToCreateUserWithRights(String path, String type) throws Throwable {
        response = request.body("{\n" +
                "  \"enabled\": true,\n" +
                "  \"password\": \"test1234\",\n" +
                "  \"roles\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \""+type+"\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"username\": \""+type+"\"\n" +
                "}").when().post(path);

    }

    @Given("^I have access to an user with \"([^\"]*)\" rights$")
    public void iHaveAccessToAnUserWithRights(String role) throws Throwable {
        users = new UserCredentials();
        request=given().baseUri("http://bhdtest.endava.com:8080/petclinicSecured/api").
                auth().preemptive().basic(users.GetCredentials(role)[0],users.GetCredentials(role)[1]).contentType(ContentType.JSON);
    }

    @When("^I will perform a GET request to \"([^\"]*)\"$")
    public void iWillPerformAGETRequestTo(String path) throws Throwable {
        response=request.when().get(path);
    }

    @Then("^I will get status code \"([^\"]*)\"$")
    public void iWillGetStatusCode(int status) throws Throwable {
        response.then().statusCode(status);
    }

    @When("^I will perform a POST veterinarian request to \"([^\"]*)\"$")
    public void iWillPerformAPOSTRequestTo(String path) throws Throwable {
        response=request.body("{\n" +
                "  \"firstName\": \"Teo\",\n" +
                "  \"id\": 0,\n" +
                "  \"lastName\": \"Veterinarul\",\n" +
                "  \"specialties\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"surgery\"\n" +
                "    }\n" +
                "  ]\n" +
                "}").when().post(path);
    }

    @When("^I will perform a DELETE veterinarian request to \"([^\"]*)\"$")
    public void iWillPerformADELETERequestTo(String path) throws Throwable {
        response=request.pathParam("vetID",1).when().delete(path);
    }

    @When("^I will perform a PUT veterinarian request to \"([^\"]*)\"$")
    public void iWillPerformAPUTRequestTo(String path) throws Throwable {
        response=request.pathParam("vetID",1).
                body("{\n" +
                "  \"firstName\": \"Teo\",\n" +
                "  \"id\": 0,\n" +
                "  \"lastName\": \"Veterinarul\",\n" +
                "  \"specialties\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"surgery\"\n" +
                "    }\n" +
                "  ]\n" +
                "}").when().put(path);
    }

    @When("^I will perform a POST owner request to \"([^\"]*)\"$")
    public void iWillPerformAPOSTOwnerRequestTo(String path) throws Throwable {
        response=request.body("{\n" +
                "  \"address\": \"Nothing\",\n" +
                "  \"city\": \"Nowhere\",\n" +
                "  \"firstName\": \"Teodor\",\n" +
                "  \"id\": 0,\n" +
                "  \"lastName\": \"Mierlita\",\n" +
                "  \"pets\": [\n" +
                "    {\n" +
                "      \"birthDate\": \"2018-10-30T10:36:03.948Z\",\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\",\n" +
                "      \"owner\": {},\n" +
                "      \"type\": {\n" +
                "        \"id\": 0,\n" +
                "        \"name\": \"string\"\n" +
                "      },\n" +
                "      \"visits\": [\n" +
                "        {\n" +
                "          \"date\": \"yyyy/MM/dd\",\n" +
                "          \"description\": \"string\",\n" +
                "          \"id\": 0,\n" +
                "          \"pet\": {}\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "  \"telephone\": \"0749999999\"\n" +
                "}").when().post(path);
    }

    @When("^I will perform a DELETE owner request to \"([^\"]*)\"$")
    public void iWillPerformADELETEOwnerRequestTo(String path) throws Throwable {
        response=request.pathParam("ownerID",1).when().delete(path);
    }

    @When("^I will perform a PUT owner request to \"([^\"]*)\"$")
    public void iWillPerformAPUTOwnerRequestTo(String path) throws Throwable {
        response=request.pathParam("ownerID",1).
                body("{\n" +
                        "  \"address\": \"Nothing\",\n" +
                        "  \"city\": \"Nowhere\",\n" +
                        "  \"firstName\": \"Teodor\",\n" +
                        "  \"id\": 0,\n" +
                        "  \"lastName\": \"Mierlita\",\n" +
                        "  \"pets\": [\n" +
                        "    {\n" +
                        "      \"birthDate\": \"2018-10-30T10:36:03.969Z\",\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\",\n" +
                        "      \"owner\": {},\n" +
                        "      \"type\": {\n" +
                        "        \"id\": 0,\n" +
                        "        \"name\": \"string\"\n" +
                        "      },\n" +
                        "      \"visits\": [\n" +
                        "        {\n" +
                        "          \"date\": \"yyyy/MM/dd\",\n" +
                        "          \"description\": \"string\",\n" +
                        "          \"id\": 0,\n" +
                        "          \"pet\": {}\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"telephone\": \"0749999999\"\n" +
                        "}").when().put(path);
    }
}
