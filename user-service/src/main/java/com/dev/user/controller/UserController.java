package com.dev.user.controller;

import com.dev.user.entity.User;
import com.dev.user.model.ResponseTemplate;
import com.dev.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/data")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public ResponseTemplate createUser(@RequestBody User user){
        log.info("createUser of Controller : "+ user);
        return null;
    }

    @DeleteMapping(value = "/delete")
    public ResponseTemplate deleteUser(@RequestBody User user){
        log.info("deleteUser of Controller : "+ user);
        return null;
    }

    @PutMapping(value = "/update")
    public ResponseTemplate updateUser(@RequestBody User user){
        log.info("updateUser of Controller : "+ user);
        return null;
    }

    @GetMapping("/get/{id}")
    public ResponseTemplate getUser(@PathVariable("id") Long userId){
        log.info("getUser of Controller : "+ userId);
        return null;
    }

    @GetMapping("/getAll")
    public ResponseTemplate getAllUsers(){
        return null;
    }

}
