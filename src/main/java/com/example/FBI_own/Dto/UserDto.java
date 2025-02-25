package com.example.FBI_own.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserDto(String password,String firstName,String lastName,String email) {

        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password = password;

    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
