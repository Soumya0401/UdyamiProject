Feature: User Registration Form Udyami Yojana

  Scenario: User registers with valid data
    Given I launch the registration page
    When I fill the registration form with fake data
    And I submit the form
    Then I confirm the registration
    Then I confirm the success message
    And user enter the OTP
    Then user verify the OTP 
    Then user click on success
    
    
    
    
  