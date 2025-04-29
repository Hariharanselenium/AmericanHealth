 @SingleUser @fulltest
Feature: SU_TC06_Login_with_Valid_Username_Invalid_Password 

@SU_TC06_Login_with_Valid_Username_Invalid_Password 
Scenario: TC_06 Login with Valid Username Invalid  Password
  Given User navigates to the login page "https://app.cpraedcourse.com/user/login?version=v2"
  When User enters invalid login credentials:
    | Field    | Value              |
    | Username | JohnDoeShankar     |
    | Password | 12345678           |
  And User clicks on the Login button
  Then User should see an error message "The Username/Password combination doesn't match. Please try again."
  

