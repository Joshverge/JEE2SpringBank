package com.jeespb.accountservice.controller;

import com.jeespb.accountservice.dto.AccountDto;
import com.jeespb.accountservice.dto.request.AccountInfoRequestDto;
import com.jeespb.accountservice.dto.response.AccountResponseDto;
import com.jeespb.accountservice.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bank/user")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @ResponseBody
    @PostMapping("/dashboard/accountInfo")
    public AccountResponseDto getAccountInfo(@RequestBody AccountInfoRequestDto requestDto) {
        AccountDto[] accounts = accountService.getAccountInfo(requestDto.getUserID());
        return new AccountResponseDto(accounts);
    }

}
