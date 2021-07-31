package com.icommerce.productservice.service;

import com.icommerce.productservice.dto.LoginDto;
import com.icommerce.productservice.dto.UserDto;
import com.icommerce.productservice.dto.request.LoginRequestDto;
import com.icommerce.productservice.dto.response.UserResponseDto;
import com.icommerce.productservice.exception.ServiceException;
import com.icommerce.productservice.service.downstream.DatabaseService;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    private final DatabaseService databaseService;

    public LoginService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public LoginDto authenticate(LoginRequestDto loginRequestDto) {
        UserResponseDto userResponse = databaseService.fetchUser(loginRequestDto.getUserId());

        UserDto userDto = userResponse.getData();
        if (!loginRequestDto.getPassword().equals(userDto.getPassword())) {
            throw new ServiceException(String.format("Password doest not match"));
        }

        LoginDto loginDto = new LoginDto();
        loginDto.setCustomerName(userDto.getCustomerName());
        loginDto.setCustomerType(userDto.getUserType());
        return loginDto;
    }

}
