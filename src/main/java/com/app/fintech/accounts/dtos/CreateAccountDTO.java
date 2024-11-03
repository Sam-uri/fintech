package com.app.fintech.accounts.dtos;

import com.app.fintech.accounts.enums.AccountType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAccountDTO {
    @NotBlank(message = "userId must not be null")
    private String userId;
    @Min(value =10, message = "minimum amount (10) should be deposit")
    private double deposit;
    @NotBlank(message = "type must be choose")
    private String type;
}
