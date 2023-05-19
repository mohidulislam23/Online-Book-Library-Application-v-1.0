package com.bjitacademy.securityModule.controllers;

import com.bjitacademy.securityModule.model.AuthenticationRequest;
import com.bjitacademy.securityModule.model.AuthenticationResponse;
import com.bjitacademy.securityModule.model.UserRequestModel;
import com.bjitacademy.securityModule.service.UserService;
import com.bjitacademy.securityModule.service.impl.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody UserRequestModel requestModel){
        return userService.register(requestModel);
    }

    private final AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest){
        return new ResponseEntity<>(authenticationService.login(authenticationRequest), HttpStatus.OK);
    }

}
