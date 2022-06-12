package io.testexample.pojo;

public class LocationAddPlaceRequest {

    private double lat;
    private double lng;

    public LocationAddPlaceRequest() {
    }

    @Override
    public String toString() {
        return "LocationAddPlaceRequest{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    public LocationAddPlaceRequest(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
