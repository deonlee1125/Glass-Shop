package com.example.glassshop.models.forms;

import com.example.glassshop.models.ArtistName;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SearchArtForm {


    private String artistName;

    private String description;

    private Integer trackingNumber;

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(Integer trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
