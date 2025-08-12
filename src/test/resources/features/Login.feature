Feature: User Login Form Udyami Yojana

   Scenario: User logs in with valid data
     Given User is on the login page with a registered Aadhaar
     When User enters valid Aadhaar and password
     And User clicks the Login button
     #Then User should be logged in successfully
