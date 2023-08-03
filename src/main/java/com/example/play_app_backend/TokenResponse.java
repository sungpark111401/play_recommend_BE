package com.example.play_app_backend;
import com.fasterxml.jackson.annotation.JsonProperty;
public class TokenResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("expires_in")
    private int expiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;

    @Override
    public String toString(){
        return "token response: \n" +
                "accessToken: " + accessToken + "\n" +
                "tokenType: " + tokenType + "\n" +
                "expiresIn: " + expiresIn + "\n" +
                "refreshToken: " + refreshToken + "\n";
    }



}
