package com.icommerce.productservice.service.downstream;

import com.icommerce.productservice.dto.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DatabaseService {

    @Value("${microservices.databaseservice.authentication}")
    private String fetchUserUrl;

    private final RestTemplate restTemplate;

    public DatabaseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserResponseDto fetchUser(String username) {
        String url = String.format(fetchUserUrl, username);
        ResponseEntity<UserResponseDto> response = restTemplate.getForEntity(url, UserResponseDto.class);
        return response.getBody();
    }
}
