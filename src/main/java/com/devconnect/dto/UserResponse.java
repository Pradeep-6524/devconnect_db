package com.devconnect.dto;

import lombok.Builder;
import lombok.Data;

//@Data
//@Builder
public class UserResponse {

    private long id;
    private String email;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

        private String email;
        private String password;
        private long id;


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

        public UserResponse build()
        {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(this.id);
            userResponse.setEmail(this.email);
            userResponse.setPassword(this.password);
            return  userResponse;
        }
    }
}
