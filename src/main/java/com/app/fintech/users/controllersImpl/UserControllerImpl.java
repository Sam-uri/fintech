package com.app.fintech.users.controllersImpl;

import com.app.fintech.users.controllers.UserController;
import com.app.fintech.users.dtos.CreateUserDTO;
import com.app.fintech.users.dtos.UserDTO;
import com.app.fintech.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO getUserById(String id) {
        return userService.getUserById(id);
    }

    @Override
    public UserDTO createUser(CreateUserDTO user) {
        return userService.createUser(user);
    }

    @Override
    public List<UserDTO> fetchAllUsers() {
        return userService.getAllUsers();
    }
}
