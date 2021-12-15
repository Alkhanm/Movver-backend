package com.github.alkhanm.movver.services.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String msg){
        super(msg);
    }
}
