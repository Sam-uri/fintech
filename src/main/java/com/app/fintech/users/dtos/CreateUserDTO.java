package com.app.fintech.users.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserDTO {
    @NotBlank(message = "Username must not be null")
    private String username;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotNull
    private String role;
}
