package com.example.currency_trader.exception;

public class BadRequestParametersException extends Exception{

    public BadRequestParametersException() {
        super("не верные параметры запроса");
    }

    public BadRequestParametersException(String message) {
        super(message);
    }

}
