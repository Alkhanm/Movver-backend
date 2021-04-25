package com.github.alkhanm.movver.services;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(){
        super("Usuário ou senha não são válidos");
    }
}
