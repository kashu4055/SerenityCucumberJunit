Feature: Creating new list
  As WL logged in user I should be able to create new list

  Scenario: User cancels new list creation dialog
       Given  User log-in to WL
       And    User is in List View
       When  User tries to create new list
       Then   User should be able to cancel the list creation action

  Scenario: Hit IBD REST EP and print IBD Doc
    Given I hit the IBD enpoint and download the delivery document