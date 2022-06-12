Feature: Validating Place API's

  @AddPlace
  Scenario Outline: Verify If Place is being Successfully Added
    Given Add Place Payload with "<name>", "<language>" and "<address>"
    When user calls "AddPlaceAPI" with "Post" http request
    Then the API call is success with status code 200
    And "status" is response body "OK"
    And "scope" is response body "APP"
    And vefify place_Id created maps to "<name>" using "GetPlaceAPI"


    Examples:
      | name        | language | address   |
      | AdemTest167 | English  | Balikesir |
#      | AdemTest2 | Turkish  | Ankara    |
#      | AdemTest3 | Arabic   | Antep     |
#      | AdemTest4 | Italian  | Adana     |

  @DeletePlace
  Scenario: Verify if Delete Place functionality is working
    Given Delete Place Payload
    When user calls "DeletePlaceAPI" with "Post" http request
    Then the API call is success with status code 200
    And "status" is response body "OK"