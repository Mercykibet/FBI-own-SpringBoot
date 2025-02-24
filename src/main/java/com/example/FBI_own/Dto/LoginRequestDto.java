package com.example.FBI_own.Dto;

public class LoginRequestDto {

    private String email;
    private String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
    private void setEmail(String email){
        this.email=email;
    }

    public String getPassword(){
        return password;
    }
    private void setPassword(String password){
        this.password=password;
    }

}
