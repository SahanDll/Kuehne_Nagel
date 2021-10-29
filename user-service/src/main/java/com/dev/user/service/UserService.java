package com.dev.user.service;

import com.dev.user.entity.User;
import com.dev.user.model.ResponseTemplate;

public interface UserService {

    ResponseTemplate createUser(User user);
    ResponseTemplate deleteUser(long userId);
    ResponseTemplate updateUser(User user);
    ResponseTemplate getUser(long userId);
    ResponseTemplate getAll();
}
