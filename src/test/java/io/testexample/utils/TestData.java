package io.testexample.utils;

import com.github.javafaker.Faker;
import io.testexample.pojo.AddPlaceRequest;
import io.testexample.pojo.LocationAddPlaceRequest;

import java.util.ArrayList;
import java.util.List;

public class TestData {

    public static AddPlaceRequest postPlaceBody(String name, String language, String address){

        AddPlaceRequest addPlaceRequest = new AddPlaceRequest();
        LocationAddPlaceRequest locationPostPlace = new LocationAddPlaceRequest();
        locationPostPlace.setLat(Double.parseDouble(new Faker().address().latitude()));
        locationPostPlace.setLng(Double.parseDouble(new Faker().address().latitude()));
        List<String> types = new ArrayList<>();
        types.add("shoepark"); types.add("test");
        addPlaceRequest.setTypes(types);
        addPlaceRequest.setLocation(locationPostPlace);
        addPlaceRequest.setAccuracy(50);
        addPlaceRequest.setName(name);
        addPlaceRequest.setPhone_number(new Faker().phoneNumber().phoneNumber());
        addPlaceRequest.setWebsite("www.google.com");
        addPlaceRequest.setLanguage(language);
        addPlaceRequest.setAddress(address);
        return addPlaceRequest;
    }

    public static String deletePlacePayload(String placeID){

        return "{\n" +
                "    \"place_id\":\""+placeID+"\"\n" +
                "}";
    }
}
