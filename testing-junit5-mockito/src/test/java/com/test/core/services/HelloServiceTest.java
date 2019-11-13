package com.test.core.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.core.services.UserService;

//https://docs.spring.io/spring-boot/docs/2.1.2.RELEASE/reference/htmlsingle/#boot-features-testing-spring-boot-applications
@SpringBootTest
public class HelloServiceTest {

    @Autowired
    UserService helloService;

    @DisplayName("Test Spring @Autowired Integration")
    @Test
    void testGet() {
        assertEquals("Hello JUnit 5", helloService.get());
    }

}