 @SingleUser @fulltest @All_Test
   Feature: SU_TC03_Register_with_existing_accounts_credentials

  @SU_TC03_Register_with_existing_accounts_credentials
  Scenario: TC_03 Register(with existing accounts credentials)
  Given User navigate to "https://staging2-cpraedcourse.gitview.net/register" for SingleUser registration 
  When User enters the following valid existing registration details:
    | Field         | Value                 |
    | First Name    | John                  |
    | Last Name     | Doe                   |
    | Phone Number  | 9876543210            |
    | Email Address | john.doe@example.com  |
    | Username      | johndoe               |
    | Password      | Secure@123            |
    | Confirm Password | Secure@123         |
  And User agrees to the Terms and Privacy Policy
  And User clicks on the Register Now button
  Then User should not be navigated to the dashboard page
    

 