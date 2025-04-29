@SingleUser @fulltest 
   Feature: SU_TC13_Register_with_Group_Code

  @SU_TC13_Register_with_Group_Code
  Scenario: TC13_Register_with_Group_Code
  Given User navigate to "https://staging2-cpraedcourse.gitview.net/register" for SingleUser registration 
  When User enters the following valid registration details with Group Code:
    | Field         | Value                |
    | First Name    | John1                |
    | Last Name     | Doe1                 |
    | Phone Number  | 98765432109          |
    | Email Address | john.doe@gmail.com   |
    | Username      | johndoe              |
    | Password      | Secure@123           |
    | Confirm Password | Secure@123        |
    | Group Code     | XSRB10-bdc8         |
  And User agrees to the Terms and Privacy Policy
  And User clicks on the Register Now button
 Then User should not be navigated to dashboard page


