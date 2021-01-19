package com.araditc.pushnotification.struct;

import com.araditc.pushnotification.consts.MessageTypes;

public class LocationStruct extends MessageTemplate{
    private int id;
    private double lat;
    private double lng;
    private String caption;

    public LocationStruct( ) {
        super(MessageTypes.LOCATION);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
