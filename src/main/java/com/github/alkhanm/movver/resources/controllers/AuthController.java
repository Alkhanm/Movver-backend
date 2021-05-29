package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.mapper.UserMapper;
import com.github.alkhanm.movver.domain.transference.Credentials;
import com.github.alkhanm.movver.domain.User;
import com.github.alkhanm.movver.domain.transference.UserAuthenticated;
import com.github.alkhanm.movver.domain.transference.UserResponse;
import com.github.alkhanm.movver.services.AuthenticatorService;
import com.github.alkhanm.movver.services.JwtService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticatorService authenticatorService;
    private final JwtService jwtService;

    public AuthController(AuthenticatorService authenticatorService, JwtService jwtService) {
        this.authenticatorService = authenticatorService;
        this.jwtService = jwtService;
    }

    @PostMapping
    private @ResponseBody
    UserAuthenticated login (@RequestBody Credentials credentials) {
        User userAuthenticated = authenticatorService.authenticate(credentials);
        String token = jwtService.generateToken(userAuthenticated);
        UserResponse user = UserMapper.INSTANCE.toResponse(userAuthenticated);
        return new UserAuthenticated(user, token);
    }

    @PostMapping("/token-validation")
    private @ResponseBody
    Boolean validateToken (@RequestBody String token) {
        return jwtService.validateToken(token);
    }
}
