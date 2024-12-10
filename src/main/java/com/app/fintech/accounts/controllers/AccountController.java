package com.app.fintech.accounts.controllers;

import com.app.fintech.accounts.dtos.AccountDTO;

import com.app.fintech.accounts.dtos.CreateAccountDTO;
import com.app.fintech.accounts.dtos.TransactionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import static com.app.fintech.accounts.apis.AccountAPI.*;



@RequestMapping("/api/v1/accounts")
@Tag(name="account")
public interface AccountController {

    @Operation(summary = "fetch account by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "account fetched"),
            @ApiResponse(responseCode = "400",description = "issue while requesting account"),
            @ApiResponse(responseCode = "404",description = "no account with this id")
    })
    @GetMapping(GET_ACCOUNT)
    @PreAuthorize("hasRole({'USER','ADMIN'})")
    AccountDTO getAccountById(@PathVariable("id") String accountId);

    @Operation(summary = "create account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "account is created",
            content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = CreateAccountDTO.class)) }),
            @ApiResponse(responseCode = "400",description = "issue while creating account")
    })
    @PreAuthorize("hasRole({'ADMIN'})")
    @PostMapping(CREATE_ACCOUNT)
     AccountDTO createAccount(@RequestBody CreateAccountDTO account);

    @Operation(summary = "perform transaction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",description = "transaction completed",
                    content = { @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TransactionDTO.class)) }),
            @ApiResponse(responseCode = "400",description = "issue while performing transaction")
    })
    @PreAuthorize("hasRole({'USER','ADMIN'})")
    @PostMapping(TRANSACTION)
    String performTransaction(@PathVariable("accountId")String  accountId ,
                              @RequestBody TransactionDTO transaction);
}
