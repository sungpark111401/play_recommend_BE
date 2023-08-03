package com.example.play_app_backend;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FormData {
    @JsonProperty("mood")
    private String mood;
    @JsonProperty("genre")
    private String genre;
    @JsonProperty("energy")
    private String energy;
    @JsonProperty("artist")
    private String artist;
    @JsonProperty("decade")
    private String decade;
    @JsonProperty("instrument")
    private String instrument;
    @JsonProperty("extra")
    private String extra;

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getDecade() {
        return decade;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "mood='" + mood + '\'' +
                ", genre='" + genre + '\'' +
                ", energy='" + energy + '\'' +
                ", artist='" + artist + '\'' +
                ", decade='" + decade + '\'' +
                ", instrument='" + instrument + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }

    // getters
    public String getMood() {
        return mood;
    }

    public String getGenre() {
        return genre;
    }

    public String getEnergy() {
        return energy;
    }

    public String getArtist() {
        return artist;
    }

    public String getDecade() {
        return decade;
    }

    public String getInstrument() {
        return instrument;
    }

    public String getExtra() {
        return extra;
    }
}
