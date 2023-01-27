package com.example.springbootvendas.rest.controller;

import com.example.springbootvendas.exception.RegraDeNegocioException;
import com.example.springbootvendas.rest.ApiErrors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraDeNegocioException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handlerRegraDeNegocioException(RegraDeNegocioException ex){
        String mensagemErro = ex.getMessage();
        return new ApiErrors(mensagemErro);
    }
}
