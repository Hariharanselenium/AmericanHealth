@GroupUser @fulltest 
Feature: C_TC_08_Forgot_password_with_valid_registered_email

@C_TC_08_Forgot_password_with_valid_registered_email
Scenario: TC_08 Verify Forgot Password Functionality Using a Valid Registered Email Address
  Given User navigates to the group login page "https://staging2-cpraedcourse.gitview.net/groupadmin/login"
  When GroupUser taps on Click Here to Reset
  Then GroupUser should redirected to the Group Reset Password page 
    When GroupUser enter the Username/Email as "rohan1223@cpraedcourse.com"
  When GroupUser hit the Send Instructions
  Then GroupUser should see the message as "Instructions have been emailed on how to reset your password."
  


