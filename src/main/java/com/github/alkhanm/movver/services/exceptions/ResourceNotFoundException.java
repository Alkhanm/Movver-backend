package com.github.alkhanm.movver.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){
        super("Recurso não encontrado");
    }
}
