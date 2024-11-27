package com.green.userservice.user.service;

import com.green.userservice.error.UserException;
import com.green.userservice.jwt.JwtUtils;
import com.green.userservice.user.jpa.User;
import com.green.userservice.user.jpa.UserRepository;
import com.green.userservice.user.vo.LoginResponse;
import com.green.userservice.user.vo.UserRequest;
import com.green.userservice.user.vo.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    @Override
    public void join(UserRequest userRequest) {

        String email = userRequest.getEmail();

        userRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new UserException(String.format("User email %s already exist", email));
                });

        User entity = userRequest.toEntity();
        entity.setUuid(UUID.randomUUID().toString());

        userRepository.save(entity);
    }

    @Override
    public UserResponse getUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(String.format("User id %s not found", userId)));

        return UserResponse.from(user);
    }

    @Override
    public List<UserResponse> getUserList() {

        return userRepository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }

    @Override
    public LoginResponse login(String email, String password) {

        // email + password 확인 후 틀리면 Exception 처리
        User user = userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(
                        () -> new UserException("Invalid email or password")
                );
        // 로그인한 유저가 있으면 loginResponse 객체 생성해서 controller 에 반환
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUuid(user.getUuid());
        loginResponse.setAccessToken(jwtUtils.createAccessToken(user.getEmail(), user.getUuid()));
        loginResponse.setRefreshToken(jwtUtils.createRefreshToken(user.getEmail()));
        loginResponse.setEmail(user.getEmail());

        return loginResponse;
    }
}
