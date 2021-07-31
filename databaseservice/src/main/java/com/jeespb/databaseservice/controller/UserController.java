package com.jeespb.databaseservice.controller;

import com.jeespb.databaseservice.dto.UserDto;
import com.jeespb.databaseservice.dto.request.AuthenticationRequestDto;
import com.jeespb.databaseservice.dto.request.LoginDetailRequestDto;
import com.jeespb.databaseservice.dto.response.UserResponseDto;
import com.jeespb.databaseservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/domain/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping(value = "/authentication")
    public UserResponseDto fetchPassword(@RequestBody AuthenticationRequestDto requestDto) {
        UserDto userDto = userService.authenticate(requestDto);
        return new UserResponseDto(userDto);
    }

    @ResponseBody
    @PutMapping(value = "/updateLoginDetails")
    public void updateLoginDetails(@RequestBody LoginDetailRequestDto requestDto) {
        userService.updateLoginDetails(requestDto);
    }
}
