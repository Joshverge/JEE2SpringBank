package com.jeespb.databaseservice.controller;

import com.jeespb.databaseservice.dto.UserDto;
import com.jeespb.databaseservice.dto.response.UserResponseDto;
import com.jeespb.databaseservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/domain/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping(value = "/authentication")
    public UserResponseDto fetchPassword(@RequestParam("username") String username) {
        UserDto userDto = userService.fetchPassword(username);
        return new UserResponseDto(userDto);
    }

}
