Feature:Automation halfords com in my pc
  @sai
  Scenario: check quick book
    #Given the user lands on halfords homepage
    And the user click on accept all cookie
    And user click on Account icon
    And user enter email and password in the log pop up
    And user click on log in button
#    And the user click on motoring on the global header menu
#    And user enter vrn postcode on motoring page

  @dip
  Scenario: user searches for the scenario
    #Given the user lands on halfords homepage
    And the user click on accept all cookie
    And the user searches for the sku
    And the user waits for the page to load
    And user select the first product from clp page


  @dip2
  Scenario: user validates bike build
    #Given the user lands on halfords homepage
    And the user click on accept all cookie
    Given the user searches for the sku
    And the user waits for the page to load
    And user select the first product from clp page
    And the user waits for the page to load
    And user click on Build My Bike on pdp
    And the user waits for the page to load
    And the user enter postcode B90 1AD on pdp
    When the click on choose a collection day button
    And the user selects a morning timeslot from the calender
    Then the user click on book selected appointment








