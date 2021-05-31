package com.github.alkhanm.movver.domain.exceptions;

public class InvalidActionException extends RuntimeException {
    public InvalidActionException(String msg){
        super(msg);
    }
}
