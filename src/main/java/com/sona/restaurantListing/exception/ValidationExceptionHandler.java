package com.sona.restaurantListing.exception;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@Hidden
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<FieldErrorResponse> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> new FieldErrorResponse(
                        e.getField(),
                        e.getDefaultMessage()
                )).toList();
        return createResponseError(fieldErrors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        List<FieldErrorResponse> fieldErrors = ex.getConstraintViolations().stream()
                .map(v -> new FieldErrorResponse(
                        v.getPropertyPath().toString(),
                        v.getMessage()
                )).toList();
        return createResponseError(fieldErrors);
    }
    private ResponseEntity<ErrorResponse> createResponseError(List<FieldErrorResponse> fieldErrors) {
        ErrorResponse errorResponse = ErrorResponse.of("Validation failed", "VALIDATION_ERROR", fieldErrors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateKeyException(DataIntegrityViolationException ex) {
        ErrorResponse error = new ErrorResponse("A restaurant with the same name and city already exists.", "RESTAURANT_EXISTS", null);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}