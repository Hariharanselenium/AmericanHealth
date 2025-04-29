@SingleUser @fulltest
   Feature: SU_TC02_Register_with_leaving_one_mandatory_field_blank

  @SU_TC02_Register_with_leaving_one_mandatory_field_blank 
  Scenario: TC_02 Register(leaving one mandatory field blank)
  Given User navigate to "https://staging2-cpraedcourse.gitview.net/register" for SingleUser registration 
  When User enters the following valid registration details with leaving one mandatory field blank
    | Field         | Value                  |
    | First Name    | John1                  |
    | Last Name     | Doe1                   |
    | Phone Number  | 9876543210             |
    | Email Address | john.doe@gmail.com |
    | Username      | johndoe                |
    | Password      | Secure@123             |
    | Confirm Password | Secure@123          |
    
  When User agrees to the Terms and Privacy Policy
  And User clicks on the Register Now button
  Then User should see an error message
  And User should not be navigated to the dashboard page
 
