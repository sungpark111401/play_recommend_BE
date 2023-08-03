package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.example.models.TrackList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpotifyResponse {
    private TrackList tracks;

    public TrackList getTracks() {
        return tracks;
    }
}
