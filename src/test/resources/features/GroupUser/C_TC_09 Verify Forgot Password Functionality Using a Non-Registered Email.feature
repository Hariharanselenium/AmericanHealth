@GroupUser @fulltest
Feature: C_TC_09_Forgot_password_with_invalid_registered_email

@C_TC_09_Forgot_password_with_invalid_registered_email
Scenario: TC_09 Verify Forgot Password Functionality Using a Non-Registered/Invalid Email Address
  Given User navigates to the group login page "https://staging2-cpraedcourse.gitview.net/groupadmin/login"
 When GroupUser taps on Click Here to Reset
 Then GroupUser should redirected to the Group Reset Password page 
  When GroupUser enter the Username/Email as "priya@thinkime.in"
  And GroupUser hit the Send Instructions
  Then GroupUser should see the message as "Account not found. Please use a Registered email"
