package com.app.fintech.accounts.controllers;

import com.app.fintech.accounts.dtos.AccountDTO;

import com.app.fintech.accounts.dtos.CreateAccountDTO;
import com.app.fintech.accounts.dtos.TransactionDTO;
import org.springframework.web.bind.annotation.*;



import static com.app.fintech.accounts.apis.AccountAPI.*;



@RequestMapping("/api/v1/accounts")
public interface AccountController {

    @GetMapping(GET_ACCOUNT)
    AccountDTO getAccountById(@PathVariable("id") String accountId);

    @PostMapping(CREATE_ACCOUNT)
     AccountDTO createAccount(@RequestBody CreateAccountDTO account);

    @PostMapping(TRANSACTION)
    String performTransaction(@PathVariable("accountId")String  accountId ,
                              @RequestBody TransactionDTO transaction);
}
