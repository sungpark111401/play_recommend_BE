package com.example.play_app_backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackItem {
    @JsonProperty("name")
    private String trackName;

    @JsonProperty("artists")
    private List<Artist> artists;

    public String getName() {
        return trackName;
    }

    public List<Artist> getArtists() {
        return artists;
    }
}
