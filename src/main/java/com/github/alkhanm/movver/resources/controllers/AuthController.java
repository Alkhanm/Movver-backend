package com.github.alkhanm.movver.resources.controllers;

import com.github.alkhanm.movver.domain.User;
import com.github.alkhanm.movver.domain.mapper.UserMapper;
import com.github.alkhanm.movver.domain.transference.Credentials;
import com.github.alkhanm.movver.domain.transference.UserAuthenticated;
import com.github.alkhanm.movver.domain.transference.UserResponse;
import com.github.alkhanm.movver.services.AuthenticatorService;
import com.github.alkhanm.movver.services.JwtService;
import com.github.alkhanm.movver.services.exceptions.InvalidRequestException;
import com.github.alkhanm.movver.services.exceptions.ResourceNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    // Documentação: http://server:port/context-path/swagger-ui.html
    // http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
    @PostMapping
    @Operation(summary = "")
    @ApiResponse(responseCode = "200", description = "Usuário e senha são válidos", content = {@Content(schema = @Schema(implementation = Credentials.class))})
    @ApiResponse(responseCode = "400", description = "Usuário e senha não são válidos", content = {@Content})
    UserAuthenticated login(@RequestBody Credentials credentials) {
        User userAuthenticated = authenticatorService.authenticate(credentials);
        String token = jwtService.generateToken(userAuthenticated);
        UserResponse user = UserMapper.INSTANCE.toResponse(userAuthenticated);
        return new UserAuthenticated(user, token);
    }

    // Recebe um token e verifica se este é válido para autenticação
    @PostMapping("/token-validation")
    private @ResponseBody
    Boolean validateToken(@RequestBody(required = false) String token) {
        if (token != null) return jwtService.validateToken(token);
        throw new InvalidRequestException("O token é nulo");
    }
}
