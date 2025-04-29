 @SingleUser @fulltest
Feature: SU_TC05_login_valid_credentials  

@SU_TC05_login_valid_credentials  
Scenario: TC_05 Login with Valid Credentials
  Given User navigates to the login page "https://app.cpraedcourse.com/user/login?version=v2"
  When User enters valid login credentials:
    | Field    | Value              |
    | Username | JohnDoeShankar     |
    | Password | 123456             |
  And User clicks on the Login button
  Then User should redirected to the dashboard


