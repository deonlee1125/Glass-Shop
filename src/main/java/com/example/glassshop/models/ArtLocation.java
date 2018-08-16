package com.example.glassshop.models;

public enum ArtLocation {
    GALLERY ("Main Gallery"),
    PEDESTAL ("Artist's Pedestal"),
    REMOVED ("Removed");

    private final String name;

    ArtLocation(String name) { this.name = name; }
    public String getName() { return name; }
}
