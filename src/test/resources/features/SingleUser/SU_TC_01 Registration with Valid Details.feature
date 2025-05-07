@SingleUser @fulltest @All_Test
   Feature: SU_TC01_Register_with_valid_credentials

  @SU_TC01_Register_with_valid_credentials
  Scenario: TC_01 Registration with Valid Details
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


