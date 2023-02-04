package com.example.springbootvendas.exception;

public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {
        super("Senha invalida");
    }
}
