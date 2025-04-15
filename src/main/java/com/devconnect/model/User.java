package com.devconnect.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String email;
    private String password;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserBuilder builder()
    {
        return new UserBuilder();
    }

    public static class UserBuilder{
        private String username;
        private String email;
        private String password;
        private long id;

        public UserBuilder username(String username)
        {
            this.username = username;
            return this;
        }
        public UserBuilder email(String email)
        {
            this.email = email;
            return this;
        }
        public UserBuilder id(long id)
        {
            this.id = id;
            return this;
        }
        public UserBuilder password(String password)
        {
            this.password = password;
            return this;
        }

        public User build()
        {
            User user = new User();
            user.setId(this.id);
            user.setEmail(this.email);
            user.setPassword(this.password);
            user.setUsername(this.username);
            return user;
        }
    }
}
