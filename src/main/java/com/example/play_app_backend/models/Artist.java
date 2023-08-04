package com.example.play_app_backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {
    @JsonProperty("name")
    private String artistName;

    public String getName() {
        return artistName;
    }
}
