Feature: PetClinic UI

  Scenario: User calls web services in order to access PetClinic Homepage
    Given I have access to the PetClinic platform
    When I access the homepage
    Then The Welcome header will be displayed
    And The welcome message "Welcome" will be displayed
    And The welcome image will be displayed


  Scenario:User creates a new owner
    Given I have access to the PetClinic platform
    And I have access to create a new owner
    And I create a new owner firstname "Peter", lastname "Pan", address "Nothing", city "Nowhere", telephone "0749999999"
    When I look in the All Owners page
    Then The owner "Peter Pan" will be displayed


  Scenario: User creates new veterinarian
    Given I have access to the PetClinic platform
    And I have access to create new veterinarian
    And I create a new veterinarian firstname "Teodor", lastname "Mierlita"
    When I look in the All Veterinarians page
    Then The veterinarian "Teodor Mierlita" will be displayed

  Scenario: User deletes a new added veterinarian
    Given I have access to the PetClinic platform
    And I have access to create new veterinarian
    And I create a new veterinarian firstname "Jack", lastname "Sparrow"
    And I delete the new added veterinarian "Jack Sparrow"
    When I look in the All Veterinarians page
    Then The veterinarian "Jack Sparrow" will not be displayed

  Scenario: User creates a new pet type
    Given I have access to the PetClinic platform
    And I have access to create a new pet type
    And I create a new pet type "cocostarc"
    When I look in the Pet Types page
    Then The pet type "cocostarc" will be displayed

  Scenario: User edits a new added pet type
    Given I have access to the PetClinic platform
    And I have access to create a new pet type
    And I create a new pet type "crocobaur"
    And I edit the new added pet from "crocobaur" to "crocobaurEdited"
    When I look in the Pet Types page
    Then The pet type "crocobaurEdited" will be displayed

  Scenario: User deletes a new added pet type
    Given I have access to the PetClinic platform
    And I have access to create a new pet type
    And I create a new pet type "cocostarcDelete"
    And I delete the new pet type "cocostarcDelete"
    When I look in the Pet Types page
    Then The pet type "cocostarcDelete" will not be displayed

