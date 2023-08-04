package com.example.play_app_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotifyResponse {
    @JsonProperty("tracks")
    private TrackList tracks;

    public TrackList getTracks() {
        return tracks;
    }
}
