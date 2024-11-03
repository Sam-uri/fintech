package com.app.fintech.users.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {
    private String id;
    private String username;
    private String email;
    private String role;
}
