package com.jeespb.databaseservice.service;

import com.jeespb.databaseservice.dto.UserDto;
import com.jeespb.databaseservice.dto.request.AuthenticationRequestDto;
import com.jeespb.databaseservice.dto.request.LoginDetailRequestDto;
import com.jeespb.databaseservice.exception.ServiceException;
import com.jeespb.databaseservice.model.SessionStatus;
import com.jeespb.databaseservice.model.User;
import com.jeespb.databaseservice.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserDto authenticate(AuthenticationRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername());
        if (user == null) {
            throw new ServiceException(String.format("User '%s' not found.", requestDto.getUsername()));
        }
        if (SessionStatus.ACTIVE.equals(user.getSessionStatus())) {
            throw new ServiceException("User session is active");
        }

        user.setSessionStatus(SessionStatus.ACTIVE);
        userRepository.save(user);

        return UserDto.from(user);
    }

    public void updateLoginDetails(LoginDetailRequestDto requestDto) {
        User user = userRepository.findByUsername(requestDto.getUsername());
        if (user == null) {
            throw new ServiceException(String.format("User '%s' not found.", requestDto.getUsername()));
        }

        user.setCustomerSessionId(requestDto.getSessionId());
        user.setLastLoginDate(new Date());
        userRepository.save(user);
    }
}
