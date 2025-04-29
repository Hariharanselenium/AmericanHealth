@SingleUser @fulltest
Feature: SU_TC11_Take_Quiz_failed_in_quiz

  @SU_TC11_Take_Quiz_failed_in_quiz
  Scenario: TC_11 Take Quiz (failed in quiz)
  Given User navigate to "https://staging2-cpraedcourse.gitview.net/register" for SingleUser registration 
  When User enters the following valid registration details:
    | Field         | Value                |
    | First Name    | John1                |
    | Last Name     | Doe1                 |
    | Phone Number  | 98765432109          |
    | Email Address | john.doe@example.com |
    | Username      | johndoe              |
    | Password      | Secure@123           |
    | Confirm Password | Secure@123        |
  And User agrees to the Terms and Privacy Policy
  And User clicks on the Register Now button
    Then User is on the Are you a Healthcare Provider? page

    When User selects "Yes, I am a healthcare provider"
   Then User should be navigated to the Please choose your profession page

    When User selects the profession as "Doctor / Physicians"
    Then User should be navigated to the Course Selection page

    When User selects the course as "Combo Healthcare Provider BLS"
    Then User lands on the Course Page

    When User taps on the Take Quiz button
    Then User lands on the Quiz Page

    When User attends all the 20 questions with some wrong answer
    And User taps on the Submit Quiz button
    Then User lands on the Quiz Fail Page
    And User should be able to see the fail message as "You did not reach a passing score of 75% or higher. You may re-attempt the quiz at no additional charge."
    

    