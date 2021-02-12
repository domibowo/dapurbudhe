package com.domibowo.dapurbudhe.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Something wrong with your file attachment")
public class FileStorageErrorException extends RuntimeException{
    public FileStorageErrorException(Throwable cause) {
        super("Something wrong with file attachment", cause.getCause());
    }
}
