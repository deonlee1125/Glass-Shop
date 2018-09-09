package com.example.glassshop.models;

public enum ArtistName {
    NULL_VALUE (""),
    ALEXANDER_DANIEL ("Alexander, Dan"),
    ASVALDSDOTTIR_ELIN ("Asvaldsdottir, Elin"),
    AUER_DOUGLAS ("Auer, Doug"),
    BRAZZLE_RICHARD ("Brazzle, Rick"),
    FLEMING_ELIZABETH ("Fleming, Liz"),
    FROST_TRAVIS ("Frost, Travis"),
    KOPITSKE_JESSICA ("Kopitske, Jes"),
    KREBECK_SANDRA ("Krebeck, Sandy"),
    LEE_JAMES ("Lee, James"),
    MIDDENDORF_LENDY ("Middendorf, Lendy"),
    MORAN_MICHAEL ("Moran, Mike"),
    PARSONS_MICHAEL ("Parsons, Mike"),
    TAGLIAPIETRI_LINO ("Tagliapietri, Lino"),
    TSIMERMAN_MAX ("Tsimerman, Max"),
    WASHINGTON_DORETHA ("Washington, Doretha");

    private final String name;

    ArtistName(String name) { this.name = name; }
    public String getName() { return name; }
}
