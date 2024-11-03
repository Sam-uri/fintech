package com.app.fintech.users.controllers;

import com.app.fintech.users.apis.UserAPI;
import com.app.fintech.users.dtos.CreateUserDTO;
import com.app.fintech.users.dtos.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.fintech.users.apis.UserAPI.*;

@RequestMapping("/api/v1/users")
public interface UserController{

    @GetMapping(READ_USER)
    UserDTO getUserById(@PathVariable("id") String id);

    @PostMapping(CREATE_USER)
    UserDTO createUser(@RequestBody CreateUserDTO user);

    @GetMapping(USERS_LIST)
    List<UserDTO> fetchAllUsers();

}
