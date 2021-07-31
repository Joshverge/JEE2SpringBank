package com.icommerce.productservice.controller;

import com.icommerce.productservice.dto.LoginDto;
import com.icommerce.productservice.dto.request.LoginRequestDto;
import com.icommerce.productservice.dto.response.LoginResponseDto;
import com.icommerce.productservice.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bank/user")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ResponseBody
    @PostMapping("/authentication")
    public LoginResponseDto search(@RequestBody LoginRequestDto loginRequestDto) {
        LoginDto loginDto = loginService.authenticate(loginRequestDto);
        return new LoginResponseDto(loginDto);
    }

}
