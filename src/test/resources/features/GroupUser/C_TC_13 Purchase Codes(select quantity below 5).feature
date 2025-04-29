@GroupUser @fulltest
Feature: C_TC_13_Purchase Codes(select quantity below 5)

  @C_TC_13_Purchase_Codes_select_quantity_below_5
  Scenario: C_TC_13_Purchase Codes(select quantity below 5)

  Given User navigates to the group login page "https://staging2-cpraedcourse.gitview.net/groupadmin/login"
  When GroupUser enters login credentials:
    | Field    | Value                           |
    | Email    | rohan1223@cpraedcourse.com      |
    | Password | Rohan@123                       |
  And GroupUser taps on the Login button
  Then GroupUser should redirected to the GroupUser dashboard page

    When GroupUser tap on the Purchase Codes button
    Then GroupUser should be navigated to the Purchase Code page
  
    When GroupUser enter quantity as 1 for "CPR/AED & First Aid & Bloodborne Course" course
    And GroupUser enter "Rohan" in Purchase Order
    And GroupUser taps the Pay Invoice button
    Then GroupUser should see an alert saying "The total number of courses per invoice must be at least 5!"


    
    
    

