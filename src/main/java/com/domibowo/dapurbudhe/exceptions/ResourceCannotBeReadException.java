package com.domibowo.dapurbudhe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Read resource cannot be done")
public class ResourceCannotBeReadException extends RuntimeException{
    public ResourceCannotBeReadException(Throwable cause) {
        super("Read resource cannot be done", cause.getCause());
    }
}
