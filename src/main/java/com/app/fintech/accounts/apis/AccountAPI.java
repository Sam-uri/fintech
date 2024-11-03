package com.app.fintech.accounts.apis;

public interface AccountAPI {
    String GET_ACCOUNT = "/{id}";
    String CREATE_ACCOUNT = "";
    String TRANSACTION = "/transaction/{accountId}";
}
