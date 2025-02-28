package com.example.FBI_own.Service;

import com.example.FBI_own.Dto.UserDto;
import com.example.FBI_own.Entity.User;
import com.example.FBI_own.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void  registerUser(UserDto userDTO) {
        // Check if email already exists
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email is already taken");
        }
        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        // Create a new User entity from the DTO
        User user = new User(
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                encodedPassword
        );

         userRepository.save(user);

    }


}
