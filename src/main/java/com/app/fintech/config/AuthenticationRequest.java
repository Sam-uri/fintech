package com.app.fintech.config;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;

}