package io.testexample.stepDefs;

import io.cucumber.java.Before;

public class Hooks {

    PlaceValidations stepDefMethods;

    @Before("@DeletePlace")
    public void setUp(){


        if(PlaceValidations.place_id==null){
            stepDefMethods = new PlaceValidations();
            stepDefMethods.add_place_payload_with_and("AdemHook","Turkish","Europe");
            stepDefMethods.user_calls_with_http_request("AddPlaceAPI","POST");
            stepDefMethods.vefify_place_id_created_maps_to_using("AdemHook","GetPlaceAPI");
        }

    }



}
