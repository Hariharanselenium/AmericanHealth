@GroupUser @fulltest  
Feature: C_TC_04_login_valid_credentials

@C_TC_04_login_valid_credentials  
Scenario: TC_04 Login with Valid Credentials
  Given User navigates to the group login page "https://staging2-cpraedcourse.gitview.net/groupadmin/login"
  When GroupUser enters login credentials:
    | Field    | Value                           |
    | Email    | rohan1223@cpraedcourse.com      |
    | Password | Rohan@123                       |
  And GroupUser taps on the Login button
  Then GroupUser should redirected to the GroupUser dashboard page

