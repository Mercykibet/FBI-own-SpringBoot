package com.example.FBI_own.Controller;


import com.example.FBI_own.Dto.LoginRequestDto;
import com.example.FBI_own.Dto.LoginResponseDto;
import com.example.FBI_own.Dto.UserDto;
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

    @Autowired
    private UserService userService;
    private final UserRepository userRepository;
    @Autowired
    //private JwtService jwtService;
    private JwtUtil jwtUtil;


    public AuthController(UserService userService, UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;

    }
    @Autowired
    private AuthService authService;
//Register user
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto){
        try {
            UserDto createUser=userService.registerUser(userDto);
            return ResponseEntity.ok(createUser);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(null);
        }
    }


    // Login User
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> loginUser(@RequestBody LoginRequestDto loginRequest) {
        boolean isValidUser = authService.validateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (isValidUser) {
            String token = jwtUtil.generateToken(loginRequest.getEmail());
            return ResponseEntity.ok(new LoginResponseDto(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }



}
