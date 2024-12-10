package com.app.fintech.users.controllers;

import com.app.fintech.users.apis.UserAPI;
import com.app.fintech.users.dtos.CreateUserDTO;
import com.app.fintech.users.dtos.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.fintech.users.apis.UserAPI.*;

@RequestMapping("/api/v1/users")
@Tag(name="user")
public interface UserController{

    @Operation(summary = "fetch User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "ok"),
            @ApiResponse(responseCode = "400",description = "issue with request"),
            @ApiResponse(responseCode = "404", description = "record not found")
    })
    @GetMapping(READ_USER)
    UserDTO getUserById(@PathVariable("id") String id);

    @Operation(summary = "create user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "user is created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateUserDTO.class)) }),
            @ApiResponse(responseCode = "400",description = "issue while creating user")
    })
    @PostMapping(CREATE_USER)
    UserDTO createUser(@RequestBody CreateUserDTO user);

    @Operation(summary = "fetch all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "list of users"),
            @ApiResponse(responseCode = "400",description = "issue with request"),
            @ApiResponse(responseCode = "404",description = "no list of users")
    })
    @GetMapping(USERS_LIST)
    List<UserDTO> fetchAllUsers();

}
