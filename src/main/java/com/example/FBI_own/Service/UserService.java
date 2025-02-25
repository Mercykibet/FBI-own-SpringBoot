package com.example.FBI_own.Service;

import com.example.FBI_own.Dto.UserrDto;
import com.example.FBI_own.Entity.User;
import com.example.FBI_own.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void  registerUser(UserrDto userDTO) {
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


//        user.setFirstName(userDTO.getFirstName());
//        user.setLastName(userDTO.getLastName());  // Added missing parentheses
//        user.setEmail(userDTO.getEmail());
//        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        // Save the user to the database
          userRepository.save(user);

        // Convert the saved User entity back to UserDTO for response
       // return new UserrDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());

    }


}
