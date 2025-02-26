package com.example.FBI_own.Controller;


import com.example.FBI_own.Dto.LoginRequestDto;
import com.example.FBI_own.Dto.Response;
import com.example.FBI_own.Dto.UserDto;
import com.example.FBI_own.Repository.UserRepository;
import com.example.FBI_own.Security.JwtUtil;
import com.example.FBI_own.Service.AuthService;
import com.example.FBI_own.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    ObjectMapper mapper;

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
    public ResponseEntity<Response<String>> registerUser(@RequestBody UserDto userDto){
        try {
            userService.registerUser(userDto);
            Response<String> r = new Response<>();
            r.setMessage("Success");
            r.setStatus(201);
            r.setData(null);
            return new ResponseEntity<>(r, HttpStatus.CREATED);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(null);
        }
    }


    // Login User
    @PostMapping("/login")
    public ResponseEntity<Response<String>> loginUser(@RequestBody LoginRequestDto loginRequest) {
        boolean isValidUser = authService.validateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (isValidUser) {
            String token = jwtUtil.generateToken(loginRequest.getEmail());
            Response<String> r = new Response<>();
            r.setMessage("Success");
            r.setStatus(201);
            r.setData(token);
            return new ResponseEntity<>(r, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
