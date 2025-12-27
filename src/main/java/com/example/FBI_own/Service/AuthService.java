package com.example.FBI_own.Service;


import com.example.FBI_own.Entity.User;
import com.example.FBI_own.Repository.UserRepository;
import com.example.FBI_own.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;


    public AuthService(UserRepository userRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean validateUser(String email, String password){
        Optional<User> user = userRepository.findByEmail(email);
        return user.filter(value -> passwordEncoder.matches(password, value.getPassword())).isPresent();
    }
}
