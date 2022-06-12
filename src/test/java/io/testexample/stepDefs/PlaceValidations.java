package io.testexample.stepDefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.testexample.utils.APIResources;
import io.testexample.utils.BaseTest;
import io.testexample.utils.TestData;
import org.hamcrest.Matchers;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;


public class PlaceValidations extends BaseTest {
    Response response;
    RequestSpecification request;
    static String place_id;

    @Given("Add Place Payload with {string}, {string} and {string}")
    public void add_place_payload_with_and(String name, String language, String address) {
        request = given().spec(requestSpecification()).body(TestData.postPlaceBody(name,language,address));
    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        APIResources apiResources = APIResources.valueOf(resource);
        if(method.equalsIgnoreCase("POST")){
            response = request.when().post(apiResources.getResource());  
        } else if (method.equalsIgnoreCase("GET")) {
            response = request.when().get(apiResources.getResource());
        } else if (method.equalsIgnoreCase("DELETE")) {
            response = request.when().delete(apiResources.getResource());
        }
    }
    @Then("the API call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("{string} is response body {string}")
    public void is_response_body(String keyValue, String expectedValue) {
        response.then().assertThat().body(keyValue, Matchers.equalTo(expectedValue));
    }
    @Then("vefify place_Id created maps to {string} using {string}")
    public void vefify_place_id_created_maps_to_using(String expectedName, String resource) {
        place_id = response.jsonPath().get("place_id");
        request = given().spec(requestSpecification()).queryParam("place_id",place_id);
        user_calls_with_http_request(resource, "GET");
        assertEquals(response.jsonPath().get("name"),expectedName);
    }

    @Given("Delete Place Payload")
    public void delete_place_payload() {
        request = given().spec(requestSpecification()).body(TestData.deletePlacePayload(place_id));
    }

}
