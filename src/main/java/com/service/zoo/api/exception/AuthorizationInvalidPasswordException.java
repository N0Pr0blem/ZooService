package com.service.zoo.api.exception;

public class AuthorizationInvalidPasswordException extends Exception{
    public AuthorizationInvalidPasswordException(String message){
        super(message);
    }
}
