package com.app.fintech.accounts.controllersImpl;

import com.app.fintech.accounts.controllers.AccountController;
import com.app.fintech.accounts.dtos.AccountDTO;
import com.app.fintech.accounts.dtos.CreateAccountDTO;
import com.app.fintech.accounts.dtos.TransactionDTO;
import com.app.fintech.accounts.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountControllerImpl implements AccountController {

    @Autowired
    private AccountService accountService;

    @Override
    public AccountDTO getAccountById(String id) {

        return accountService.getAccountById(id);
    }

    @Override
    public  AccountDTO createAccount(CreateAccountDTO account) {
        return accountService.createAccount(account);
    }

    @Override
    public String performTransaction(String accountId, TransactionDTO transaction) {
        return accountService.performTransaction( accountId, transaction);

    }
}
