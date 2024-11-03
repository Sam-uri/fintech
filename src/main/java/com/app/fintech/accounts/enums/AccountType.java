package com.app.fintech.accounts.enums;

public enum AccountType {
    SAVINGS,
    CURRENT,
    UNKNOWN;

    public static AccountType of(String type){
        for(AccountType value: AccountType.values()){
           if(type.equalsIgnoreCase(value.name()))
               return value;
        }
        return UNKNOWN;
    }
}
