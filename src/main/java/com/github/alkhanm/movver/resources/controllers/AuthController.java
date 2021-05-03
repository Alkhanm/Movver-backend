package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.entities.Client;
import com.github.alkhanm.movver.domain.entities.Credentials;
import com.github.alkhanm.movver.domain.entities.Driver;
import com.github.alkhanm.movver.domain.entities.User;
import com.github.alkhanm.movver.domain.entities.transference.UserAuthenticated;
import com.github.alkhanm.movver.services.AuthenticatorService;
import com.github.alkhanm.movver.services.JwtService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
        User user = authenticatorService.authenticate(credentials);
        String token = jwtService.generateToken(user);
        return new UserAuthenticated(user, token);
    }
}