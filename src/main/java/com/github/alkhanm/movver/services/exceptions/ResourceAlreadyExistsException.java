package com.github.alkhanm.movver.services.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String msg){
        super(msg);
    }
}
