@GroupUser @fulltest 
Feature: C_TC_06_login_invalid_username_valid_password
                                        
@C_TC_06_login_invalid_username_valid_password  
Scenario: TC_06 Login with Invalid Username valid  Password
Given User navigates to the group login page "https://staging2-cpraedcourse.gitview.net/groupadmin/login"
  When GroupUser enters login credentials:
    | Field    | Value              |
    | Email    | JohnDoeShank       |
    | Password | Rohan@123            |
And GroupUser taps on the Login button
  Then GroupUser should see an error message "Your email / password combination is invalid." on the GroupUser login page
  

