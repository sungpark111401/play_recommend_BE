package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import com.example.models.TrackItem;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TrackList {
    private List<TrackItem> items;

    public List<TrackItem> getItems() {
        return items;
    }
}
