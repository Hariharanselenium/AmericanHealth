@GroupUser @fulltest
Feature: C_TC_12_Purchase Codes(select quantity above 5)

  @C_TC_12_Purchase_Codes_select_quantity_above_5
  Scenario: C_TC_12 Purchase Codes(select quantity above 5)

  Given User navigates to the group login page "https://staging2-cpraedcourse.gitview.net/groupadmin/login"
  When GroupUser enters login credentials:
    | Field    | Value                           |
    | Email    | rohan1223@cpraedcourse.com      |
    | Password | Rohan@123                       |
  And GroupUser taps on the Login button
  Then GroupUser should redirected to the GroupUser dashboard page

    When GroupUser tap on the Purchase Codes button
    Then GroupUser should be navigated to the Purchase Code page
  
    And GroupUser enter quantity as 9 for "First Aid Course" course
    And GroupUser enter "Rohan" in Purchase Order
    And GroupUser tap the Pay Invoice button
    Then GroupUser should be navigated to the Invoice Payment page
    
     When GroupUser enters billing address details:
      | Field       | Value                |
      | First Name  | John                 |
      | Last Name   | Doe                  |
      | Company     | ABC Corporation      |
      | Address     | 123 Main Street      |
      | City        | New York             |
      | State       | CA - California      |
      | Zip         | 10001                | 
     And GroupUser enters the payment details:
    | Field                | Value                |
    | Full Name on Card    | johndoe              |
    | Card Number          | 4242424242424242     |
    | Expiration Month     | 12                   |
    | Expiration Year      | 27                   |
    | CVV Code             | 123                  |
    And GroupUser clicks on Submit Payment button
    Then GroupUser should be navigated to the Invoice page
    Then Group User should see that the total invoice amount is the same on the Create Invoice page and the Invoice page.
  




    
    
    

