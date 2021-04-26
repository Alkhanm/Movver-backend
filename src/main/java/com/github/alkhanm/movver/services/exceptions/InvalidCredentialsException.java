package com.github.alkhanm.movver.services.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(){
        super("Usuário ou senha não são válidos");
    }
}
