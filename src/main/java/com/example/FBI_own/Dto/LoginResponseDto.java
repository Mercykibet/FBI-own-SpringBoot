package com.example.FBI_own.Dto;

public class LoginResponseDto {

    private String token;

    public LoginResponseDto(String token) {

        this.token = token;
    }

    private String setToken(){
        return token;
    }
}
