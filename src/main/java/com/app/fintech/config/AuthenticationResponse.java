package com.app.fintech.config;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


public class AuthenticationResponse {
    public AuthenticationResponse(String accessToken, double expiresIn, String refreshToken) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
    }

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private double expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;


}
