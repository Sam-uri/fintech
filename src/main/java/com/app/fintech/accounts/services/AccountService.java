package com.app.fintech.accounts.services;

import com.app.fintech.accounts.dtos.AccountDTO;
import com.app.fintech.accounts.dtos.CreateAccountDTO;
import com.app.fintech.accounts.dtos.TransactionDTO;
import com.app.fintech.accounts.entities.Account;
import com.app.fintech.accounts.enums.AccountType;
import com.app.fintech.accounts.repositories.AccountRepository;

import com.app.fintech.users.entities.User;
import com.app.fintech.users.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(AccountService.class);

    public AccountDTO getAccountById(String id){
        log.info("accessing the account of "+id);
        return getBuild(findById(id));
    }

    private static AccountDTO getBuild(Account acc) {
        return AccountDTO.builder()
                .accountId(String.valueOf(acc.getId()))
                .userId(String.valueOf(acc.getUser().getId()))
                .username(acc.getUser().getUsername())
                .email(acc.getUser().getEmail())
                .accountType(acc.getAccountType().name())
                .balance(acc.getBalance())
                .build();
    }

    public AccountDTO createAccount(CreateAccountDTO accountDTO) {
        User user = userService.getUserEntityById(accountDTO.getUserId());
        Account accountEntity = accountRepository.saveAndFlush(Account.builder()
                        .user(user)
                        .balance(accountDTO.getDeposit())
                        .createdAt(LocalDate.now())
                        .updatedAt(LocalDate.now())
                        .accountType(AccountType.of(accountDTO.getType()))
                .build());

        return getBuild(accountEntity);
    }

    private Account findById(String accId){
       return accountRepository.findById(Long.valueOf(accId))
                .orElseThrow(()->
                        new RuntimeException("Account is not available with this id:-"+accId)
                );
    }
    public String performTransaction(String accountId, TransactionDTO transaction) {

        Account senderAccount = findById(accountId);
        if(transaction.getTransferAmount() > senderAccount.getBalance()){
            log.warn("insufficient funds for account"+senderAccount.getId());
            return "insufficient funds";
        }
        Account targetAccount = findById(transaction.getTargetAccountId());
        double targetAccUpdate = targetAccount.getBalance()+transaction.getTransferAmount();
        targetAccount.setBalance(targetAccUpdate);
        targetAccount.setUpdatedAt(LocalDate.now());
        accountRepository.save(targetAccount);

        double senderAccUpdate = senderAccount.getBalance()-transaction.getTransferAmount();
        senderAccount.setBalance(senderAccUpdate);
        senderAccount.setUpdatedAt(LocalDate.now());
        accountRepository.saveAndFlush(senderAccount);

        log.info("{0} transfered amount to {1}",senderAccount.getId(), targetAccount.getId());
        return "Transaction Successful";
    }
}
