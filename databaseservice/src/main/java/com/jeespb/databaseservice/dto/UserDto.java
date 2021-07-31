package com.jeespb.databaseservice.dto;

import com.jeespb.databaseservice.model.SessionStatus;
import com.jeespb.databaseservice.model.User;

import java.util.Date;
import java.util.UUID;

public class UserDto {
    private String username;
    private String password;
    private String userType;
    private String customerName;
    private String sessionId;
    private SessionStatus sessionStatus;
    private Date lastLoginDate;

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setUserType(user.getUserType());
        userDto.setCustomerName(user.getCustomerName());
        userDto.setSessionStatus(user.getSessionStatus());
        userDto.setLastLoginDate(user.getLastLoginDate());
        userDto.setSessionId(UUID.randomUUID().toString());
        return userDto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public SessionStatus getSessionStatus() {
        return sessionStatus;
    }

    public void setSessionStatus(SessionStatus sessionStatus) {
        this.sessionStatus = sessionStatus;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}
