@GroupUser @fulltest 
Feature: C_TC_02_Register_with_leaving_one_mandatory_field_blank

  @C_TC_02_Register_with_leaving_one_mandatory_field_blank  
  Scenario: TC_02 Corporate Register(leaving one mandatory field blank)
  Given GroupUser navigate to "https://staging2-cpraedcourse.gitview.net/groupdiscount" for Group registration
  When GroupUser enters the group registration details with leaving one mandatory field blank
    | Field         | Value               |
    | First Name    | John                |
    | Last Name     | Doe                 |
    | Company Name  | Thinktime           |
    | Phone Number  | 0987654123          |
    | Email Address | john.doe@example.com|
    | Create Password   | Secure@123      |
    | Confirm Password  | Secure@123      |
  And GroupUser clicks on the Register button
  Then GroupUser should see the missing field error message
  And GroupUser should not be navigated to the Corporate dashboard page
 
