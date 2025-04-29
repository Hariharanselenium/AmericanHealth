@SingleUser @fulltest @fultest
   Feature: SU_TC_14_Register_to_the_website(Quiz_Register_Payment)

  @SU_TC_14_Register_to_the_website_Quiz_Register_Payment
  Scenario: TC_14 Register to the website(Quiz_Register_Payment)
  Given User navigate to "https://cpraedcourse.com/" 
  When User clicks on the Start Now button
  Then User is on the Are you a Healthcare Provider? Page

  When User select "Yes, I'm a healthcare provider"
  Then User lands on Quiz Page
    
  When User attends the first 12 questions
    Then User lands on Registration Page
  And User enters the following valid register details:
    | Field             | Value              |
    | First Name        | John1              |
    | Last Name         | Doe1               |
    | Phone Number      | 98765432109        |
    | Email Address     | john.doe@gmail.com |
    | Username          | johndoe            |
    | Password          | Secure@123         |
    | Confirm Password  | Secure@123         |
      Then User lands on Quiz Page
  And User attends the remaining 8 questions
  And User taps on the Submit Quiz button
  Then User lands on the Success Quiz Page

    When User taps on Next button on the page
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


