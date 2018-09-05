package com.example.glassshop.models.forms;

import com.example.glassshop.models.ArtistName;

public class SearchForm {

    private ArtistName artistName;
    private String description;
    //private Integer trackingNumber;

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ArtistName getArtistName() { return artistName; }
    public void setArtistName(ArtistName artistName) { this.artistName = artistName; }

    //public Integer getTrackingNumber() { return trackingNumber; }
    //public void setTrackingNumber(Integer trackingNumber) { this.trackingNumber = trackingNumber; }
}