package com.github.alkhanm.movver.services.exceptions;

public class  DatabaseException extends RuntimeException {
    public DatabaseException(){
        super("Usuário ou senha não são válidos");
    }
}
