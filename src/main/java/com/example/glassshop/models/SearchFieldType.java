package com.example.glassshop.models;

public enum SearchFieldType {

    ARTISTNAME ("Artist Name"),
    TRACKINGNUMBER ("Tracking Number"),
    DESCRIPTIONKEY ("Description (enter search word or phrase)"),
    ALL ("All");

    private final String name;

    SearchFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
