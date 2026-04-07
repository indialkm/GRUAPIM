package com.APIMICROS.enderecoAPI.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> response = new HashMap<>();
        
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();
        
        response.put("erro", errorMessage);
        
        return ResponseEntity.badRequest().body(response);
    }
}