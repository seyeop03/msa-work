package com.green.userservice.user.service;

import com.green.userservice.user.vo.LoginResponse;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void join(UserRequest userRequest);

    UserResponse getUser(Long userId);

    List<UserResponse> getUserList();

    LoginResponse login(String email, String password);
}
