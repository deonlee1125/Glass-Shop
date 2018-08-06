package com.example.glassshop.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Art {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 1, message = "Please include the artist's name.")
    private String artistName;

    @NotNull(message = "Please include tracking number.")
    private Integer trackingNumber;

    @NotNull
    @Size(min = 1, message = "Please include a description of the art.")
    private String description;

    private ArtLocation location;

    @NotNull (message = "Please include the price for this art.")
    private Double price;


    //@OneToMany
    //private Art art;

    public Art(String artistName, Integer trackingNumber, String description, Double price) {
        this.artistName = artistName;
        this.trackingNumber = trackingNumber;
        this.description = description;
        this.price = price;
    }

    public Art() { }

    public int getId() { return id; }

    public String getArtistName () { return artistName; }
    public void setArtistName (String artistName){ this.artistName = artistName; }

    public Integer getTrackingNumber () { return trackingNumber; }
    public void setTrackingNumber(Integer trackingNumber) { this.trackingNumber = trackingNumber; }

    public String getDescription () { return description; }
    public void setDescription (String description){ this.description = description; }

    public ArtLocation getLocation() { return location; }
    public void setLocation(ArtLocation location) { this.location = location; }

    public Double getPrice () { return price; }
    public void setPrice (Double price){ this.price = price; }

    }