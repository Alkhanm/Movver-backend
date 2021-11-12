package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.User;
import com.github.alkhanm.movver.domain.mapper.UserMapper;
import com.github.alkhanm.movver.domain.transference.Credentials;
import com.github.alkhanm.movver.domain.transference.UserAuthenticated;
import com.github.alkhanm.movver.domain.transference.UserResponse;
import com.github.alkhanm.movver.services.AuthenticatorService;
import com.github.alkhanm.movver.services.JwtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Recebe e valida as informções para autenticação de usuário (usuário/senha)")
    @ApiResponse(responseCode = "200", description = "Usuário e senha são válidos", content = {@Content(schema = @Schema(implementation = Credentials.class))})
    @ApiResponse(responseCode = "400", description = "Usuário e senha não são válidos", content = {@Content})
    private @ResponseBody
    UserAuthenticated login(@RequestBody Credentials credentials) {
        User userAuthenticated = authenticatorService.authenticate(credentials);
        String token = jwtService.generateToken(userAuthenticated);
        UserResponse user = UserMapper.INSTANCE.toResponse(userAuthenticated);
        return new UserAuthenticated(user, token);
    }

    @PostMapping("/token-validation")
    @Operation(summary = "Lorem ipsum")
    @ApiResponse(responseCode = "200", description = "Lorem ipsum", content = {@Content(schema = @Schema(implementation = Object.class))})
    @ApiResponse(responseCode = "400", description = "Lorem ipsum", content = {@Content})
    private @ResponseBody
    Boolean validateToken(@RequestBody String token) {
        return jwtService.validateToken(token);
    }
}
