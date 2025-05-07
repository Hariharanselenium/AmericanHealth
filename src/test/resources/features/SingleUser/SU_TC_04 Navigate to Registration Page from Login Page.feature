 @SingleUser @fulltest @All_Test
   Feature: SU_TC04_Navigate_to_Registration_Page_from_Login_Page 
    
  @SU_TC04_Navigate_to_Registration_Page_from_Login_Page   
  Scenario: TC_04 Navigate to Registration Page from Login Page
  Given User navigates to the login page "https://staging2-cpraedcourse.gitview.net/user/login?version=v2" 
  When User clicks on the Register Here link
  Then User should be redirected to the registration page
  When User enters the following valid registration details:
    | Field         | Value                |
    | First Name    | John01               |
    | Last Name     | Doe                  |
    | Phone Number  | 98765432109          |
   | Email Address  | john.doe@gmail.com   |
    | Username      | johndoe              |
    | Password      | Secure@123           |
    | Confirm Password | Secure@123        |
  And User agrees to the Terms and Privacy Policy
  And User clicks on the Register Now button
  Then User should redirected to the dashboard Page
 