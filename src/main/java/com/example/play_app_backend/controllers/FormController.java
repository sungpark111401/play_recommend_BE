package com.example.play_app_backend.controllers;

import okhttp3.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.play_app_backend.FormData;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import com.example.play_app_backend.SpotifyApiClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.play_app_backend.models.SpotifyResponse;
import com.example.play_app_backend.models.TrackItem;
import java.util.List;
import com.example.play_app_backend.models.Artist;

@RestController
@RequestMapping("/api")
public class FormController {
    private SpotifyApiClient spotifyClient;

    public FormController() {
        spotifyClient = new SpotifyApiClient();
    }

    // helper to construct the query parameter q's query string!
    public String constructQueryString(FormData d) {
        String query = String.format("artist:%s genre:%s",
                d.getArtist(),
                d.getGenre());
        System.out.printf("Query String: %s", query);
        return query;
    }

    @PostMapping
    public String handleFormSubmission(@RequestBody FormData data) {
        try {
            String accessToken = spotifyClient.getAccessToken();
            System.out.println("AccessToken: " + accessToken);
            // now, with accessToken, we should utilize the data gotten from front-end to
            // look for Spotify tracks
            // that best match user criteria!

            // base url of api endpoint for /search!
            String apiUrl = "https://api.spotify.com/v1/search";
            String queryString = constructQueryString(data);
            // full url containing necessary query params!
            String fullUrl = apiUrl + '?' + "q=" + queryString + "&type=track";
            System.out.println("fullUrl: " + fullUrl);
            OkHttpClient httpClient = new OkHttpClient();
            Request req = new Request.Builder().url(fullUrl).addHeader("Authorization", "Bearer " + accessToken).get()
                    .build();
            try (Response resp = httpClient.newCall(req).execute()) {
                if (resp.isSuccessful()) {
                    String responseBody = resp.body().string();
                    ObjectMapper mapper = new ObjectMapper();
                    SpotifyResponse spotifyResp = mapper.readValue(responseBody, SpotifyResponse.class);
                    List<TrackItem> trackItems = spotifyResp.getTracks().getItems();
                    for (TrackItem ti : trackItems) {
                        String curName = ti.getName();
                        List<Artist> curArtists = ti.getArtists();
                        System.out.println("Name of current track: " + curName);
                        System.out.println("Current track has artists: \n");
                        for (Artist a : curArtists) {
                            System.out.println("artist name: " + a.getName() + "\n");
                        }
                        System.out.println("End of artist names for current track\n");
                    }
                    return responseBody;
                } else {
                    System.out.println(resp.toString());
                    return "failed to fetch tracks from spotify /search api endpoint!";
                }
            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        } catch (Exception e) {
            String errorMsg = "can't get access token";
            return errorMsg;
        }
    }
}
