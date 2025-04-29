@GroupUser @fulltest 
Feature: C_TC_05_login_valid_username_invalid_password

@C_TC_05_login_valid_username_invalid_password  
Scenario: TC_05 Login with Valid Username Invalid  Password
   Given User navigates to the group login page "https://staging2-cpraedcourse.gitview.net/groupadmin/login"
  When GroupUser enters login credentials:
    | Field    | Value              |
    | Email    | rohan1223@cpraedcourse.com      |
    | Password | 12345678           |
And GroupUser taps on the Login button
  Then GroupUser should see an error message "Your email / password combination is invalid." on the GroupUser login page
                                          
 