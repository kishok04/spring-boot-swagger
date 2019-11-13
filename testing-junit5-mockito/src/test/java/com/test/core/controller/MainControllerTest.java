package com.test.core.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.sample.core.controller.MainController;
import com.sample.core.model.User;
import com.sample.core.repository.UserRepository;
import com.sample.core.services.UserService;

@RunWith(SpringRunner.class)
//@WebMvcTest(value = MainController.class, secure = false)
@SpringBootTest(classes={MainController.class})
public class MainControllerTest {
	
	@Autowired
	private UserService service;
	
	@MockBean
	private UserRepository repository;
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;
	
	@Before
	public void setUp(){
		 mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	User user = new User("kishok",26);

	@Test
	@DisplayName("Method is to test get all users")
    public void getUser() throws Exception {
    	Mockito.when(
    			repository.getUsers()).thenReturn(
						(List<User>) Stream.of(user).collect(Collectors.toList()));
    	System.out.println(user.toString());
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/users").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{\"name\":\"kishok\",\"age\":26}]";
		Assertions.assertEquals(expected, result.getResponse()
				.getContentAsString());
    }
	@Test
	@DisplayName("Method is to test string as response")
	public void helloTest() throws Exception{
		Mockito.when(
    			repository.get()).thenReturn("hello");
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "hello";
		Assertions.assertEquals(expected, result.getResponse()
				.getContentAsString());
	}

}
