package com.app.fintech.accounts.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TransactionDTO {
    @NotBlank(message = "target account must be set")
    private String targetAccountId;
    @Min(value = 1, message = "minimum 1 amount should be transfer")
    private double transferAmount;
}
