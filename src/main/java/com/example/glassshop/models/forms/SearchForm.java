package com.example.glassshop.models.forms;

import com.example.glassshop.models.ArtistName;
import com.example.glassshop.models.SearchFieldType;

import java.lang.reflect.Field;

public class SearchForm {

    //private int artId;

    //private SearchFieldType[] fields = SearchFieldType.values();

    private Field field;
    private ArtistName artistName;
    private String description;
    private Integer trackingNumber;
    private String keyword;

    //public int getArtId() { return artId; }

    //public SearchFieldType[] getFields() { return fields; }

    //public SearchFieldType getSearchField() { return searchField; }
    //public void setSearchField(SearchFieldType searchField) { this.searchField = searchField; }

    public Field getField() { return field; }
    public void setField(Field field) { this.field = field; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ArtistName getArtistName() { return artistName; }
    public void setArtistName(ArtistName artistName) { this.artistName = artistName; }

    public Integer getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(Integer trackingNumber) { this.trackingNumber = trackingNumber; }
}