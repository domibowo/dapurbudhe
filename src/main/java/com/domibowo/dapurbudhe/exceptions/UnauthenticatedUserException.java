package com.domibowo.dapurbudhe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UnauthenticatedUserException extends RuntimeException{
    public UnauthenticatedUserException(String username) {
        super(String.format("Username %s is unacceptable", username));
    }
}
