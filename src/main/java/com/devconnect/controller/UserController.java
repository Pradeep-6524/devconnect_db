package com.devconnect.controller;


import com.devconnect.dto.UserRequest;
import com.devconnect.dto.UserResponse;
import com.devconnect.model.User;
import com.devconnect.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse registerUser(@RequestBody UserRequest userRequest) {
        return userService.registerUser(userRequest);
    }

    @GetMapping("/exists")
    public boolean checkEmailExists(@RequestParam String email)
    {
        return userService.emailExists(email);
    }

    @GetMapping("/by-email")
    Optional<User> getUserByEmail(@RequestParam String email)
    {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/by-username")
    Optional<User> getUserByUsername(@RequestParam String username)
    {
        return userService.getUserByUsername(username);
    }
    @DeleteMapping("/delete")
    @Transactional
    public String deleteByUsername(@RequestParam String username)
    {
        userService.deleteUserByUsername(username);
        return "user with username : '"+username+"' is deleted";
    }
    @GetMapping("/by-domain")
    public List<User> getUsersByEmailDomain(@RequestParam String domain)
    {
        return userService.getUsersByEmailDomain(domain);
    }
}