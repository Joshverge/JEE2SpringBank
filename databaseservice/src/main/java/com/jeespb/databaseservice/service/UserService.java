package com.jeespb.databaseservice.service;

import com.jeespb.databaseservice.dto.UserDto;
import com.jeespb.databaseservice.exception.ServiceException;
import com.jeespb.databaseservice.model.User;
import com.jeespb.databaseservice.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto fetchPassword(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new ServiceException(String.format("User '%s' not found.", username));
        }
        return UserDto.from(user);
    }
}
