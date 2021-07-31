package com.jeespb.loginservice.service;

import com.jeespb.loginservice.dto.LoginDto;
import com.jeespb.loginservice.dto.LoginStatus;
import com.jeespb.loginservice.dto.SessionStatus;
import com.jeespb.loginservice.dto.UserDto;
import com.jeespb.loginservice.dto.request.LoginDetailRequestDto;
import com.jeespb.loginservice.dto.request.LoginRequestDto;
import com.jeespb.loginservice.dto.response.UserResponseDto;
import com.jeespb.loginservice.service.downstream.DatabaseService;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class LoginService {

    private final DatabaseService databaseService;

    public LoginService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public LoginDto authenticate(LoginRequestDto loginRequestDto) {
        UserResponseDto userResponse = databaseService.authenticate(loginRequestDto.getUserId());
        if (userResponse == null) {
            return LoginDto.invalid();
        }

        UserDto userDto = userResponse.getData();
        if (!Objects.equals(userDto.getPassword(), loginRequestDto.getPassword())) {
            return LoginDto.invalid();
        }
        LoginDetailRequestDto requestDto = new LoginDetailRequestDto();
        requestDto.setSessionStatus(SessionStatus.ACTIVE);
        requestDto.setLastLoginDate(new Date());
        requestDto.setSessionId(userDto.getSessionId());
        requestDto.setUsername(userDto.getUsername());
        databaseService.updateLoginDetails(requestDto);

        LoginDto loginDto = new LoginDto();
        loginDto.setLoginStatus(LoginStatus.VALID);
        loginDto.setCustomerName(userDto.getCustomerName());
        loginDto.setCustomerType(userDto.getUserType());
        loginDto.setLastLoginDate(userDto.getLastLoginDate());
        loginDto.setSessionID(userDto.getSessionId());
        return loginDto;
    }

}
