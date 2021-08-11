package com.jeespb.accountservice.service.downstream;

import com.jeespb.accountservice.dto.AccountDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DatabaseService {

    private static Logger logger = LoggerFactory.getLogger(DatabaseService.class);

    @Value("${microservices.databaseService.accountInfo}")
    private String accountInfoUrl;

    private final RestTemplate restTemplate;

    public DatabaseService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AccountDto[] getAccountInfo(String userId) {
        String url = String.format(accountInfoUrl, userId);
        return restTemplate.getForObject(url, AccountDto[].class);
    }

}
