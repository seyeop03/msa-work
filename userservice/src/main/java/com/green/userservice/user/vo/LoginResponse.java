package com.green.userservice.user.vo;

import lombok.Data;

@Data
public class LoginResponse {

    private String accessToken;
    private String refreshToken;
    private String uuid;
    private String email;
}
