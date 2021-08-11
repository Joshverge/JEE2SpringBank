package com.jeespb.accountservice.service;

import com.jeespb.accountservice.dto.AccountDto;
import com.jeespb.accountservice.service.downstream.DatabaseService;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

    private final DatabaseService databaseService;

    public AccountService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public AccountDto[] getAccountInfo(String userId) {
        return databaseService.getAccountInfo(userId);
    }
}
