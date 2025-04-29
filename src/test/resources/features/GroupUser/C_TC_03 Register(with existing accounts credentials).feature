@GroupUser @fulltest 
Feature: C_TC_03_Register_with_existing_accounts_credentials

  @C_TC_03_Register_with_existing_accounts_credentials
  Scenario: TC_03 Corporate Register(with existing accounts credentials)
  Given GroupUser navigate to "https://staging2-cpraedcourse.gitview.net/groupdiscount" for Group registration
  When User enters the existing account details:
    | Field         | Value               |
    | First Name    | John                |
    | Last Name     | Doe                 |
    | Company Name  | Thinktime           |
    | Phone Number  | 90876543219          |
    | Email Address | john.doe@example.com|
    | Create Password   | Secure@123      |
    | Confirm Password  | Secure@123      |
  And GroupUser clicks on the Register button
  Then GroupUser should see the existing account error message
