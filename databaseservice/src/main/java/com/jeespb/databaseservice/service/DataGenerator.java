package com.jeespb.databaseservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeespb.databaseservice.model.User;
import com.jeespb.databaseservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

@Component
@ConditionalOnProperty(
        value = "data.generator.enabled",
        havingValue = "true")
public class DataGenerator {

    private final Logger logger = LoggerFactory.getLogger(DataGenerator.class);

    @Value("classpath:data/user.json")
    private Resource userResourceFile;

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    public DataGenerator(UserRepository userRepository, ResourceLoader resourceLoader) {
        this.userRepository = userRepository;
        this.resourceLoader = resourceLoader;
        this.objectMapper = new ObjectMapper();
    }

    @PostConstruct
    public void init() throws IOException {
        generateData();
    }

    private void generateData() throws IOException {
        generateUsers();
    }

    private void generateUsers() throws IOException {
        logger.info("Generating users...");
        InputStream inputStream = userResourceFile.getInputStream();
        User[] users = objectMapper.readValue(inputStream, User[].class);
        Arrays.stream(users).forEach(userRepository::save);
        logger.info("Generated {} users", users.length);
    }

}
