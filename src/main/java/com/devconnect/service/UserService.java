package com.devconnect.service;

import com.devconnect.dto.UserRequest;
import com.devconnect.dto.UserResponse;
import com.devconnect.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
    boolean emailExists(String email);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByUsername(String username);
    void deleteUserByUsername(String username);
    List<User> getUsersByEmailDomain(String domain);

}
