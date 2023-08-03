package com.example.models;

import com.example.models.Artist;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackItem {
    @JsonProperty("name")
    private String name;

    @JsonProperty("artists")
    private List<Artist> artists;

    public String getName() {
        return name;
    }
}
