package com.dev.user.service.impl;

import com.dev.user.entity.User;
import com.dev.user.model.Age;
import com.dev.user.model.ResponseTemplate;
import com.dev.user.repository.UserRepository;
import com.dev.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${ageUrl}")
    private String ageUrl;

    public ResponseTemplate createUser(User user) {
        log.info("createUser of Service");
        ResponseTemplate rt = new ResponseTemplate();
        try {
            Age age = restTemplate.getForObject(ageUrl+user.getName(), Age.class);
            if(age != null) {
                log.info("Age info : " + age.toString());
                user.setAge(age.getAge());
                userRepository.save(user);
                rt.setStatusCode("200");
                rt.setMessage("User created");
            } else {
                rt.setStatusCode("204");
                rt.setMessage("User not created");
            }
        } catch (Exception e) {
            rt.setStatusCode("503");
            rt.setMessage("Service not available");
        }
        return rt;
    }

    public ResponseTemplate deleteUser(long userId) {
        log.info("deleteUser of Service");
        ResponseTemplate rt = new ResponseTemplate();
        try {
            User user = userRepository.findByUserId(userId);
            if(user != null) {
                userRepository.deleteById(userId);
                rt.setStatusCode("200");
                rt.setMessage("User deleted");
            } else {
                rt.setStatusCode("204");
                rt.setMessage("User not found");
            }
        } catch (Exception e) {
            rt.setStatusCode("503");
            rt.setMessage("Service not available");
        }
        return rt;
    }

    public ResponseTemplate updateUser(User user) {
        log.info("updateUser of Service");
        ResponseTemplate rt = new ResponseTemplate();
        try {
            User dbUser = userRepository.findByUserId(user.getUserId());
            if(dbUser != null) {
                userRepository.save(user);
                rt.setStatusCode("200");
                rt.setMessage("User updated");
            } else {
                rt.setStatusCode("204");
                rt.setMessage("User not found");
            }
        } catch (Exception e) {
            rt.setStatusCode("503");
            rt.setMessage("Service not available");
        }
        return rt;
    }

    public ResponseTemplate getUser(long userId) {
        log.info("getUser of Service");
        ResponseTemplate rt = new ResponseTemplate();
        try {
            User user = userRepository.findByUserId(userId);
            if(user != null) {
                rt.getUserData().add(user);
                rt.setUserCount(1);
                rt.setStatusCode("200");
                rt.setMessage("User found");
            } else {
                rt.setStatusCode("204");
                rt.setMessage("User not found");
            }
        } catch (Exception e) {
            rt.setStatusCode("503");
            rt.setMessage("Service not available");
        }
        return rt;
    }

    public ResponseTemplate getAll() {
        log.info("getAll of Service");
        ResponseTemplate rt = new ResponseTemplate();
        try {
            List<User> users = userRepository.findAll();
            if(users != null && users.size() > 0) {
                rt.setUserData(users);
                rt.setUserCount(users.size());
                rt.setStatusCode("200");
                rt.setMessage("Users found");
            } else {
                rt.setStatusCode("204");
                rt.setMessage("Users not found");
            }
        } catch (Exception e) {
            rt.setStatusCode("503");
            rt.setMessage("Service not available");
        }
        return rt;
    }

}
