 @SingleUser @fulltest
Feature: SU_TC10_store_purchase 

@SU_TC10_store_purchase  
Scenario: SU_TC10_store_purchase
Given User navigate to "https://staging2-cpraedcourse.gitview.net/register" for SingleUser registration 
  When User enters the following valid registration details:
    | Field         | Value                |
    | First Name    | John1                |
    | Last Name     | Doe1                 |
    | Phone Number  | 98765432109          |
    | Email Address | john.doe@gmail.com   |
    | Username      | johndoe              |
    | Password      | Secure@123           |
    | Confirm Password | Secure@123        |
  And User agrees to the Terms and Privacy Policy
  And User clicks on the Register Now button
  Then User should redirected to the dashboard Page

  When User clicks on the Store button
   Then User should redirected to the Store Page
   
When User adds the "AHCA First Aid Student Manual" to the cart
 And User clicks on the View Cart Content button
Then User should not see the message: "Your cart is empty. Please select products before proceeding."
  
  
  


  


