package com.jeespb.databaseservice.controller;

import com.jeespb.databaseservice.dto.UserDto;
import com.jeespb.databaseservice.dto.request.AuthenticationRequestDto;
import com.jeespb.databaseservice.dto.request.LoginDetailRequestDto;
import com.jeespb.databaseservice.dto.request.SessionRequestDto;
import com.jeespb.databaseservice.dto.response.UserResponseDto;
import com.jeespb.databaseservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/domain/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping(value = "/authentication")
    public UserResponseDto authenticate(@RequestBody AuthenticationRequestDto requestDto) {
        UserDto userDto = userService.authenticate(requestDto);
        return new UserResponseDto(userDto);
    }

    @ResponseBody
    @PostMapping(value = "/session")
    public UserResponseDto getSession(@RequestBody SessionRequestDto requestDto) {
        UserDto userDto = userService.getSession(requestDto);
        return new UserResponseDto(userDto);
    }

    @ResponseBody
    @PostMapping(value = "/updateLoginDetails")
    public void updateLoginDetails(@RequestBody LoginDetailRequestDto requestDto) {
        userService.updateLoginDetails(requestDto);
    }
}
