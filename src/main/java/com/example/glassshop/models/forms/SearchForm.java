package com.example.glassshop.models.forms;

import com.example.glassshop.models.SearchFieldType;

public class SearchForm {

    private SearchFieldType[] fields = SearchFieldType.values();

    private SearchFieldType searchField = SearchFieldType.ALL;

    private String description;

    private String keyword;

    public SearchFieldType[] getFields() { return fields; }

    public SearchFieldType getSearchField() { return searchField; }
    public void setSearchField(SearchFieldType searchField) { this.searchField = searchField; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}