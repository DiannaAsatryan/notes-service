package com.mycompany.note.inbound.exception;

import com.mycompany.note.domain.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorResponse.ErrorCode.NO_RESOURCE_FOUND, ex.getMessage());
        return errorResponse;
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse genericException(Exception ex) {
        ErrorResponse errorResponse =
            new ErrorResponse(ErrorResponse.ErrorCode.INTERNAL_ERROR, "Internal error accured, contact support team.");
        return errorResponse;
    }


    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse requestValidationException(MethodArgumentNotValidException ex) {
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult().getFieldErrors()
            .forEach(e -> sb.append(e.getField()).append(" ").append(e.getDefaultMessage()).append("; "));
        ErrorResponse errorResponse = new ErrorResponse(ErrorResponse.ErrorCode.VALIDATION_ERROR, sb.toString());
        return errorResponse;
    }
}

