Feature: Testing Sample App


  @First
  Scenario: Verify User can toggle switch preference button ON
    Given  User Navigates to Switch Preferences screen
    When User taps toggle button to On status
    Then Toggle button is activated


  @Second
  Scenario: Verify User can add Wifi connection
    Given User navigates to select Preference dependencies button
    When User selects the WiFi checkbox
    And User sets the WiFi name as "Test"
    Then WiFi connection is successfully added


  @Third
  Scenario: Verify User can tick child checkbox
    Given User Navigates to select Preferences From code button
    When User select the child checkbox with a tick
    Then Child checkbox is successfully marked as ticked