package com.inventory.search.exceptions;/* Created by manumalla on 06-06-2026. */

import com.inventory.search.dto.ErrorResponse;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SearchException.class)
    public ResponseEntity<String> handleNotFound(SearchException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
    @ExceptionHandler(NoSuchMethodException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchMethod(NoSuchMethodException ex) {
        ErrorResponse error =  ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message("Method not found: ")
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(  NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NoHandlerFoundException ex) {
        ErrorResponse error =  ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message("API not found")
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(  NoResourceFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NoResourceFoundException ex) {
        ErrorResponse error =  ErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message("API not found")
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage())
                );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex) {

        log.error("Failed to process a request with exception ", ex);

        ErrorResponse error = ErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message("There is an issue while processing the request. please try again or reach Adminstractor")
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
