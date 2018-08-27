package com.example.glassshop.models;

public enum ArtistName {
    NULL_VALUE (""),
    ALEXANDER_DANIEL ("Alexander, Dan"),
    AUER_DOUGLAS ("Auer, Doug"),
    BRAZZLE_RICHARD ("Brazzle, Rick"),
    LEE_JAMES ("Lee, James"),
    MIDDENDORF_LENDY ("Middendorf, Lendy"),
    TAGLIAPIETRI_LINO ("Tagliapietri, Lino"),
    WASHINGTON_DORETHA ("Washington, Doretha");

    private final String name;

    ArtistName(String name) { this.name = name; }
    public String getName() { return name; }
}
