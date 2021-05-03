package com.github.alkhanm.movver.services.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(){
        super("Usuário ou senha não são válidos");
    }
}
