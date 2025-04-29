@GroupUser @fulltest
Feature: C_TC_14_Export_Reports

  @C_TC_14_Export_Reports
  Scenario: C_TC_14_Export_Reports

  Given User navigates to the group login page "https://staging2-cpraedcourse.gitview.net/groupadmin/login"
  When GroupUser enters login credentials:
    | Field    | Value                           |
    | Email    | rohan1223@cpraedcourse.com      |
    | Password | Rohan@123                       |
  And GroupUser taps on the Login button
  Then GroupUser should redirected to the GroupUser dashboard page

    When GroupUser taps on the Employees tap
    Then GroupUser should be redirected to the Employees page
    
    When GroupUser taps on the Export button
    Then The Employee file should be downloaded with prefix "Employees_v3_"

    
    
    

