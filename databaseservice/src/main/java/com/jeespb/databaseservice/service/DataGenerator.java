package com.jeespb.databaseservice.service;

import com.jeespb.databaseservice.model.User;
import com.jeespb.databaseservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataGenerator {

    private final Logger logger = LoggerFactory.getLogger(DataGenerator.class);

    private final UserRepository userRepository;

    public DataGenerator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        generateData();
    }

    private void generateData() {
        generateUsers();
    }

    private void generateUsers() {
        logger.info("Generating users...");
        User user1 = new User();
        user1.setUsername("abc@xyz.com");
        user1.setPassword("asdf123");
        user1.setCustomerName("Name 1");
        user1.setUserType("tier-1");
        userRepository.save(user1);

        logger.info("Generated users");
    }

}
