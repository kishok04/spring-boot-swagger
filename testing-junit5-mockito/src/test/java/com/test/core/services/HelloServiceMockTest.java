package com.test.core.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.core.repository.UserRepository;
import com.sample.core.services.UserService;
import com.sample.core.services.UserServiceImpl;

//@ExtendWith(MockitoExtension.class) , need this? still able to run.
@SpringBootTest
public class HelloServiceMockTest {

    @Mock
    private UserRepository helloRepository;

    //@Spy
    @InjectMocks // auto inject helloRepository
    private UserService helloService = new UserServiceImpl();

    @BeforeEach
    void setMockOutput() {
        //when(helloService.get()).thenReturn("Hello Mockito");
        when(helloRepository.get()).thenReturn("Hello Mockito From Responsitory");
    }

    @DisplayName("Test Mock helloService + helloRepository")
    @Test
    void testGet() {
        assertEquals("Hello Mockito From Responsitory", helloService.get());
    }

}