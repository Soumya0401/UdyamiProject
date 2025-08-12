Feature: User Personal Details Page – Udyami Yojana

 Scenario: User fills and submits the Personal Details page
     Given User is on the Personal Details form page
     When User fills in the personal details form with valid data
     And User clicks on the Save button
     #Then Personal details should be saved successfully
     
     Given User is on the Education Details form page
     When User fills in the education details form with valid data
     And User clicks on the Add button
     Then User Click on ok for Add the document
     
    