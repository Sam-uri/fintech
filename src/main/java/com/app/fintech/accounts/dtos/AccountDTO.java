package com.app.fintech.accounts.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountDTO {
    private String accountId;
    private String userId;
    private String username;
    private String email;
    private String accountType;
    private double balance;
}
