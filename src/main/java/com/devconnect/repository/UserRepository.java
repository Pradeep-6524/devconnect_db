package com.devconnect.repository;

import com.devconnect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);

    void deleteByUsername(String username);
    List<User> findByEmailEndingWith(String domain);
}