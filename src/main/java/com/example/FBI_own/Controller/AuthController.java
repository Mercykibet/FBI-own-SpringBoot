package com.example.FBI_own.Controller;


import com.example.FBI_own.Dto.LoginRequestDto;
import com.example.FBI_own.Dto.LoginResponseDto;
import com.example.FBI_own.Dto.UserDto;
import com.example.FBI_own.Dto.UserrDto;
import com.example.FBI_own.Repository.UserRepository;
import com.example.FBI_own.Security.JwtUtil;
import com.example.FBI_own.Service.AuthService;
import com.example.FBI_own.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AuthController {

    private final AuthService authService;

    private final UserService userService;

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;


    public AuthController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder, AuthService authService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.authService = authService;
        this.jwtUtil = jwtUtil;

    }

//Register user
    @PostMapping("/register")
    public ResponseEntity<UserrDto> registerUser(@RequestBody UserrDto userDto){
        try {
            return ResponseEntity.ok(userDto);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(null);
        }
    }


    // Login User
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDto loginRequest) {
        boolean isValidUser = authService.validateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (isValidUser) {
            String token = jwtUtil.generateToken(loginRequest.getEmail());
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
