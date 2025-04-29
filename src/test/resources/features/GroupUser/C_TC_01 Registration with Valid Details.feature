@GroupUser @fulltest 
Feature: C_TC_01_Corporate_Registration_with_Valid_Details

  @C_TC_01_Corporate_Registration_with_Valid_Details 
  Scenario: TC_01 Corporate Registration with Valid Details
  Given GroupUser navigate to "https://staging2-cpraedcourse.gitview.net/groupdiscount" for Group registration 
  When User enters the Corporate registration details:
    | Field         | Value               |
    | First Name    | John                |
    | Last Name     | Doe                 |
    | Company Name  | Thinktime           |
    | Phone Number  | 09876541239         |
    | Email Address | john.doe@gmail.com  |
    | Create Password   | Secure@123      |
    | Confirm Password  | Secure@123      |
   And GroupUser clicks on the Register button
   Then GroupUser should redirected to the Corporate dashboard page 
   
 