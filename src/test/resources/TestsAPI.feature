Feature: PetClinic API

#  Scenarii de creare a utilizatorilor Owner Admin si Vet Admin


#  Scenario: Create new user with specific rights
#    Given I have access to perform POST request
#    When I will perform POST request to "/users" to create user with "VET_ADMIN" rights
#    Then I will have status code "201"
#
#  Scenario: Create new user with specific rights
#    Given I have access to perform POST request
#    When I will perform POST request to "/users" to create user with "OWNER_ADMIN" rights
#    Then I will have status code "201"


#  Scenarii negative


  Scenario: Use Owner Admin user to perform GET veterinarians request
    Given I have access to an user with "OWNER_ADMIN" rights
    When I will perform a GET request to "/vets"
    Then I will get status code "400"

  Scenario: Use Owner Admin user to perform POST veterinarian request
    Given I have access to an user with "OWNER_ADMIN" rights
    When I will perform a POST veterinarian request to "/vets"
    Then I will get status code "400"

  Scenario: Use Owner Admin user to perform DELETE veterinarian request
    Given I have access to an user with "OWNER_ADMIN" rights
    When I will perform a DELETE veterinarian request to "/vets/{vetID}"
    Then I will get status code "400"

  Scenario: Use Owner Admin user to perform PUT veterinarian request
    Given I have access to an user with "OWNER_ADMIN" rights
    When I will perform a PUT veterinarian request to "/vets/{vetID}"
    Then I will get status code "400"

  Scenario: Use Vet Admin user to perform GET owners request
    Given I have access to an user with "VET_ADMIN" rights
    When I will perform a GET request to "/owners"
    Then I will get status code "400"

  Scenario: Use Vet Admin user to perform POST owner request
    Given I have access to an user with "VET_ADMIN" rights
    When I will perform a POST owner request to "/owners"
    Then I will get status code "400"

  Scenario: Use Vet Admin user to perform DELETE owner request
    Given I have access to an user with "VET_ADMIN" rights
    When I will perform a DELETE owner request to "/owners/{ownerID}"
    Then I will get status code "400"

  Scenario: Use Vet Admin user to perform PUT owner request
    Given I have access to an user with "VET_ADMIN" rights
    When I will perform a PUT owner request to "/owners/{ownerID}"
    Then I will get status code "400"


#    Scenarii pozitive


  Scenario: Use Owner Admin user to perform GET owners request
    Given I have access to an user with "OWNER_ADMIN" rights
    When I will perform a GET request to "/owners"
    Then I will get status code "200"

  Scenario: Use Vet Admin user to perform GET veterinarians request
    Given I have access to an user with "VET_ADMIN" rights
    When I will perform a GET request to "/vets"
    Then I will get status code "200"