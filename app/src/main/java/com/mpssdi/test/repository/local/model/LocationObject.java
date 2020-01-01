package com.mpssdi.test.repository.local.model;


public class LocationObject implements java.io.Serializable {

   private float lat ;
    private float lng ;

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
}
