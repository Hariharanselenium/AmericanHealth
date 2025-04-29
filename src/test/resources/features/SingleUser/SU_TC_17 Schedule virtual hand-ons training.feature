@SingleUser @fulltest @fultest
Feature: SU_TC_17_Schedule_Virtual_HandsOn_Training

  @SU_TC_17_Schedule_Virtual_HandsOn_Training
  Scenario: TC_17_Schedule_Virtual_HandsOn_Training
  Given User navigate to "https://staging2-cpraedcourse.gitview.net/register" for SingleUser registration 
  When User enters the following valid registration details:
    | Field         | Value                |
    | First Name    | John1                |
    | Last Name     | Doe1                 |
    | Phone Number  | 98765432109          |
    | Email Address | john.doe@example.com |
    | Username      | johndoe              |
    | Password      | Secure@123           |
    | Confirm Password | Secure@123        |
  And User agrees to the Terms and Privacy Policy
  And User clicks on the Register Now button
    Then User is on the Are you a Healthcare Provider? page

    When User selects "Yes, I am a healthcare provider"
   Then User should be navigated to the Please choose your profession page

    When User selects the profession as "Doctor / Physicians"
    Then User should be navigated to the Course Selection page

    When User selects the course as "Combo Healthcare Provider BLS"
    Then User lands on the Course Page
    
    When User Tap on Hands-on kit
    Then User lands on Champ Page
    
   When User selects the first available date
    And User selects the first available time slot for the selected date
    And User taps on Purchase Hands-on Training
    Then User lands on the Cart Page
    
     And User taps on Proceed to Checkout button 
      Then User lands on the Checkout Page
 
    When User enters the payment details:
    | Field                | Value                |
    | Card                 | Visa                 |
    | Card Number          | 4242424242424242     |
    | Expiration Month     | 12                   |
    | Expiration Year      | 2030                 |
    |CVV Code              | 123                  |
    |Full Name on Card     | johndoe              |
    |Billing Address       | 20, East Street      |
    |Billing City          | London               |
    |Billing State         |Texas                 |
    |Billing Zip           |11233                 |
    And User clicks on Save button

    And User enters shipping address details:
      | Field       | Value             |
      | First Name  | John               |
      | Last Name   | Doe                |
      | Company     | ABC Corporation    |
      | Address     | 123 Main Street     |
      | City        | New York            |
      | State       | New York            |
      | Zip         | 10001               |
 
   And User clicks on the Save button
    And User tap on Submit Order button
    Then User lands on the ThankYou Page
    
    
    
    
      
 
    
