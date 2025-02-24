package com.example.FBI_own.Service;

import com.example.FBI_own.Dto.UserDto;
import com.example.FBI_own.Entity.User;
import com.example.FBI_own.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserDto registerUser(UserDto userDTO) {
        // Check if email already exists
       if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email is already taken");
        }

        // Create a new User entity from the DTO
        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());  // Added missing parentheses
        user.setEmail(userDTO.getEmail());
        //user.setPassword((userDTO.getPassword()));
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Encrypt password

        // Save the user to the database
        user = userRepository.save(user);

        // Convert the saved User entity back to UserDTO for response
        return new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }


}
