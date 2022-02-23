Feature: Create a Campaign

  Scenario Outline: Create a campaign
    Given I got the access token, instance url
    When I send a request to create a campaign with <isActive> <Name> <Status>
    Then A campaign is created

    Examples:

    | isActive | Name         |  Status|
    | "true"   | "Campaign 1" | "Completed"|
    | "true"   | "Campaign 2" | "Completed"|
    | "true"   | "Campaign 3" | "Completed"|
