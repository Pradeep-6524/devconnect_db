package com.devconnect.serviceimp;

import com.devconnect.dto.UserRequest;
import com.devconnect.dto.UserResponse;
import com.devconnect.model.User;
import com.devconnect.repository.UserRepository;
import com.devconnect.service.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRespository)
    {
        this.userRepository = userRespository;
    }


    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        User user = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponse.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .password(savedUser.getPassword())
                .build();
    }

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public List<User> getUsersByEmailDomain(String domain) {
        return userRepository.findByEmailEndingWith(domain);
    }
}
