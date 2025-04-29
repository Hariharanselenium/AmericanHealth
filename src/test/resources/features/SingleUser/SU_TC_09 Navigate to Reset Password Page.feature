 @SingleUser @fulltest
Feature:SU_TC09_Navigate_to_Reset_password_page

@SU_TC09_Navigate_to_Reset_password_page
Scenario: TC_09 Navigate to Reset Password Page
 Given User navigates to the login page "https://app.cpraedcourse.com/user/login?version=v2"
  When User clicks on Click Here to Reset
  Then User should redirected to the Reset Password page 
  When User enter the Username/Email as "priya@thinktime.in"
  And User hit the Send Instructions
  Then User should see the message "Instructions have been emailed on how to reset your password."
