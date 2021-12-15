package com.github.alkhanm.movver.resources.exceptions;

import com.github.alkhanm.movver.services.exceptions.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class MovverExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public StandardError resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        String error = "Recurso não encontrado.";
        return new StandardError(Instant.now(), NOT_FOUND.value(), error, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(FORBIDDEN)
    public StandardError invalidCredentials(InvalidCredentialsException ex, HttpServletRequest request) {
        String error = "As credenciais informadas não são válidas.";
        return new StandardError(Instant.now(), FORBIDDEN.value(), error, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(DatabaseException.class)
    @ResponseStatus(BAD_REQUEST)
    public StandardError databaseException(DatabaseException ex, HttpServletRequest request) {
        String error = "Não foi possível realizar está operação";
        return new StandardError(Instant.now(), BAD_REQUEST.value(), error, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(BAD_REQUEST)
    public StandardError invalidRequestException(InvalidRequestException ex, HttpServletRequest request) {
        String error = "O servidor não pôde responder, pois a requisição foi mal formatada.";
        return new StandardError(Instant.now(), BAD_REQUEST.value(), error, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    @ResponseStatus(UNPROCESSABLE_ENTITY)
    public StandardError resourceAlreadyExists(ResourceAlreadyExistsException ex, HttpServletRequest request) {
        String error = "Esse recurso já existe.";
        return new StandardError(Instant.now(), UNPROCESSABLE_ENTITY.value(), error, ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(BAD_REQUEST)
    public StandardError emptyRequisitionBodyException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        String error = "O corpo da requisição está vazio";
        return new StandardError(Instant.now(), BAD_REQUEST.value(), error, ex.getMessage(), request.getRequestURI());
    }

}
