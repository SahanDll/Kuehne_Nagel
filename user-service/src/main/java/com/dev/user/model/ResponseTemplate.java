package com.dev.user.model;

import com.dev.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
public class ResponseTemplate {

    String statusCode;
    String message;
    List<User> userData;
    int userCount;

    public ResponseTemplate(){
        this.userData = new ArrayList<>();
    }


}
