package com.example.glassshop.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Art {

    @Id
    @GeneratedValue
    private int id;

// Changed this from Artist type to string
    private String artistName;

    @NotNull(message = "Please include tracking number.")
    private Integer trackingNumber;

    @NotNull
    @Size(min = 1, message = "Please include a description of the art.")
    private String description;

    private ArtLocation location;

    @NotNull (message = "Please include the price for this art.")
    private Double price;

    private String image;

    public Art(Integer trackingNumber, String description, Double price, String image) {
        this.trackingNumber = trackingNumber;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    public Art() { }

    public int getId() { return id; }

//    public ArtistName getArtistName () { return artistName; }
//    public void setArtistName (ArtistName artistName){ this.artistName = artistName; }


    public String getArtistName() {return artistName;}
    public void setArtistName(String artistName) {this.artistName = artistName;}

    public Integer getTrackingNumber () { return trackingNumber; }
    public void setTrackingNumber(Integer trackingNumber) { this.trackingNumber = trackingNumber; }

    public String getDescription () { return description; }
    public void setDescription (String description){ this.description = description; }

    public ArtLocation getLocation() { return location; }
    public void setLocation(ArtLocation location) { this.location = location; }

    public Double getPrice () { return price; }
    public void setPrice (Double price){ this.price = price; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}