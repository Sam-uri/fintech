package com.app.fintech.accounts.controllers;

import com.app.fintech.accounts.dtos.AccountDTO;

import com.app.fintech.accounts.dtos.CreateAccountDTO;
import com.app.fintech.accounts.dtos.TransactionDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



import static com.app.fintech.accounts.apis.AccountAPI.*;



@RequestMapping("/api/v1/accounts")
public interface AccountController {

    @GetMapping(GET_ACCOUNT)
    @PreAuthorize("hasRole({'USER','ADMIN'})")
    AccountDTO getAccountById(@PathVariable("id") String accountId);

    @PreAuthorize("hasRole({'ADMIN'})")
    @PostMapping(CREATE_ACCOUNT)
     AccountDTO createAccount(@RequestBody CreateAccountDTO account);

    @PreAuthorize("hasRole({'USER','ADMIN'})")
    @PostMapping(TRANSACTION)
    String performTransaction(@PathVariable("accountId")String  accountId ,
                              @RequestBody TransactionDTO transaction);
}
