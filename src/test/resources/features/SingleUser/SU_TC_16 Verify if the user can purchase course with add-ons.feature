@SingleUser @fulltest @fultest
Feature: SU_TC16_Verify_if_the_user_can_purchase_course_with_add-ons

  @SU_TC16_Verify_if_the_user_can_purchase_course_with_add-ons
  Scenario: TC_16 Verify if the user can purchase course with add-ons
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

    When User taps on the Take Quiz button
    Then User lands on the Quiz Page

    When User attends all the 20 questions
    And User taps on the Submit Quiz button
    Then User lands on the Quiz Success Page

    When User taps on Continue to Download Card
    Then User lands on the Payment Page

    When User enters the following payment card details:
      | Field            | Value            |
      | Full Name        | John Doe         |
      | Card Number      | 4242424242424242 |
      | Expiration Month | 12               |
      | Expiration Year  | 27               |
      | CVV              | 123              |
    And User taps on Next button
    Then User lands on the Billing and Shipping Address Page

    When User enters the following shipping and billing details:
      | Field          | Value              |
      | First Name     | John               |
      | Last Name      | Doe                |
      | Address Line 1 | 123 Main Street    |
      | City           | New York           |
      | State          | NY                 |
      | Zip Code       | 10001              |
      | Country        | USA                |
    And User taps on the Same as Billing Address radio button
    And User enters the Coupon Code "AUTO10"
    And User taps on the Submit Payment button
    Then User lands on the Continuous Education Credits and Course Renewal Page
    
     When User taps on I Accept
    Then User lands on the Hands-on Kit Page
    
    When User taps on the I Accept button
    Then User lands on the Congratulations Page
    
    When User searches the "Healthcare, First Aid & Bloodborne Pathogens Combo" course in the search bar
    And User adds the course to the cart
    And User taps on the Proceed To Checkout button
    Then User lands on Cart Information Page
    
    When User enter the Invalid Coupon as "AUTO10"
    And User tap on the Proceed to Checkout button 
    Then User should able to see the message as "Invalid coupon, make sure it is correct."
       And User tap on the Proceed to Checkout button 
    And User lands on Checkout Page
    
    When User enters the card details:
      | Field            | Value            |
      | Card Number      | 4242424242424242 |
      | Expiration Date  | 12  27           |
      | CVV              | 123              |
     And User selects the Country name as "Afghanistan"
     And User tap on Pay Now button 
     Then User lands on the Thank You Page
     
     




 