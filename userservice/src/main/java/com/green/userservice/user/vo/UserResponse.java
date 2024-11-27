package com.green.userservice.user.vo;

import com.green.userservice.user.jpa.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    private String email;
    private String name;

    public static UserResponse from(User entity){
        return new UserResponse(entity.getEmail(), entity.getName());
    }
}
