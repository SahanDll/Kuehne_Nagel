package com.dev.user.controller;

import com.dev.user.AbstractTest;
import com.dev.user.entity.User;
import com.dev.user.repository.UserRepository;
import com.dev.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.junit.jupiter.api.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest extends AbstractTest {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    private User crUser;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        crUser = new User();
        crUser.setName("Sahan");
        crUser.setEmail("sahan@mail.com");
        crUser.setPhoneNumber("0111222333");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void createUser() {
        String uri = "/data/create";
        String inputJson = null;
        try {
            inputJson = super.mapToJson(crUser);
        } catch (JsonProcessingException e) {
            log.error("Error : ", e);
        }
        MvcResult mvcResult = null;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();
        } catch (Exception e) {
            log.error("Error : ", e);
        }

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = null;
        try {
            content = mvcResult.getResponse().getContentAsString();
        } catch (UnsupportedEncodingException e) {
            log.error("Error : ", e);
        }

        String expected = "{\"statusCode\":\"200\",\"message\":\"User created\",\"userData\":[],\"userCount\":0}";
        assertEquals(expected, content);
    }

    @Test
    @Order(2)
    void getUser() {
        String uri = "/data/get/1";
        MvcResult mvcResult = null;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
            ).andReturn();
        } catch (Exception e) {
            log.error("Error : ", e);
        }

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = null;
        try {
            content = mvcResult.getResponse().getContentAsString();
        } catch (UnsupportedEncodingException e) {
            log.error("Error : ", e);
        }
        User user = userRepository.findByUserId((long) 1);
        String expected = "{\"statusCode\":\"200\",\"message\":\"User found\",\"userData\":[{\"userId\":"+ user.getUserId() +",\"name\":\""+ user.getName() +"\",\"email\":\""+ user.getEmail() +"\",\"age\":"+ user.getAge() +",\"phoneNumber\":\""+ user.getPhoneNumber() +"\"}],\"userCount\":1}";
        try {
            JSONAssert.assertEquals(expected, content, false);
        } catch (JSONException e) {
            log.error("Error : ", e);
        }
        assertEquals(expected, content);
    }

    @Test
    @Order(3)
    void updateUser() {
        String uri = "/data/update";
        String inputJson = null;
        try {
            User user = userRepository.findByUserId((long) 1);
            user.setName("Sahan Devaka");
            inputJson = super.mapToJson(user);
        } catch (JsonProcessingException e) {
            log.error("Error : ", e);
        }
        MvcResult mvcResult = null;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();
        } catch (Exception e) {
            log.error("Error : ", e);
        }

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = null;
        try {
            content = mvcResult.getResponse().getContentAsString();
        } catch (UnsupportedEncodingException e) {
            log.error("Error : ", e);
        }

        String expected = "{\"statusCode\":\"200\",\"message\":\"User updated\",\"userData\":[],\"userCount\":0}";
        assertEquals(expected, content);
    }

    @Test
    @Order(4)
    void getAllUsers() {
        String uri = "/data/getAll";
        MvcResult mvcResult = null;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
            ).andReturn();
        } catch (Exception e) {
            log.error("Error : ", e);
        }

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = null;
        try {
            content = mvcResult.getResponse().getContentAsString();
        } catch (UnsupportedEncodingException e) {
            log.error("Error : ", e);
        }
        User user = userRepository.findByUserId((long) 1);
        String expected = "{\"statusCode\":\"200\",\"message\":\"Users found\",\"userData\":[{\"userId\":"+ user.getUserId() +",\"name\":\""+ user.getName() +"\",\"email\":\""+ user.getEmail() +"\",\"age\":"+ user.getAge() +",\"phoneNumber\":\""+ user.getPhoneNumber() +"\"}],\"userCount\":1}";
        try {
            JSONAssert.assertEquals(expected, content, false);
        } catch (JSONException e) {
            log.error("Error : ", e);
        }
        assertEquals(expected, content);
    }

    @Test
    @Order(5)
    void deleteUser() {
        String uri = "/data/delete?userId=1";
        String inputJson = null;

        MvcResult mvcResult = null;
        try {
            mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
            ).andReturn();
        } catch (Exception e) {
            log.error("Error : ", e);
        }

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = null;
        try {
            content = mvcResult.getResponse().getContentAsString();
        } catch (UnsupportedEncodingException e) {
            log.error("Error : ", e);
        }

        String expected = "{\"statusCode\":\"200\",\"message\":\"User deleted\",\"userData\":[],\"userCount\":0}";
        assertEquals(expected, content);
    }

}