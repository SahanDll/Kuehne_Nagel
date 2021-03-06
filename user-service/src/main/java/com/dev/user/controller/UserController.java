package com.dev.user.controller;

import com.dev.user.entity.User;
import com.dev.user.model.ResponseTemplate;
import com.dev.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/data")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTemplate createUser(@RequestBody User user){
        log.info("createUser of Controller : "+ user);
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTemplate deleteUser(@RequestParam("userId") long userId){
        log.info("deleteUser of Controller : "+ userId);
        return userService.deleteUser(userId);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTemplate updateUser(@RequestBody User user){
        log.info("updateUser of Controller : "+ user);
        return userService.updateUser(user);
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTemplate getUser(@PathVariable("id") Long userId){
        log.info("getUser of Controller : "+ userId);
        return userService.getUser(userId);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseTemplate getAllUsers(){
        return userService.getAll();
    }

}
