package com.example.glassshop.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

//@Entity
public class Art {

    //@Id
    //@NotNull
    private Integer artistNumber;

   // @NotNull
    //@Size(min = 1, message = "Please include the artist's name.")
    private String artistName;

    //@GeneratedValue
    private Integer trackingNumber;

    //@NotNull
    //@Size(min = 1, message = "Please include a description of the art.")
    private String description;

    //@NotNull
    //@Size(min = 1, message = "Please include the location of the art within the gallery.")
    private String location;

   // @NotNull
   // @Size(min = 1, message = "Please include the price for this art.")
    private Double price;

    //@OneToMany
    //private Art art;

    public Art(Integer artistNumber, String artistName, Integer trackingNumber, String description, String location, Double price) {
        this.artistNumber = artistNumber;
        this.artistName = artistName;
        this.trackingNumber = trackingNumber;
        this.description = description;
        this.location = location;
        this.price = price;
    }

    //public Art() { }
        public Integer getArtistNumber () { return artistNumber; }
        public void setArtistNumber (Integer artistNumber){ this.artistNumber = artistNumber; }

        public String getArtistName () { return artistName; }
        public void setArtistName (String artistName){ this.artistName = artistName; }

        public Integer getTrackingNumber () { return trackingNumber; }
        public void setTrackingNumber(Integer trackingNumber) { this.trackingNumber = trackingNumber; }

        public String getDescription () { return description; }
        public void setDescription (String description){ this.description = description; }

        public String getLocation () { return location; }
        public void setLocation (String location){ this.location = location; }

        public Double getPrice () { return price; }
        public void setPrice (Double price){ this.price = price; }

    }