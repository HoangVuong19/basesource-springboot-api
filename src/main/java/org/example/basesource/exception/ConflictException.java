package org.example.basesource.exception;

import org.springframework.http.HttpStatus;

public class ConflictException extends AppException {
    public ConflictException(String message) {
        super(409, message, HttpStatus.CONFLICT);
    }
}
