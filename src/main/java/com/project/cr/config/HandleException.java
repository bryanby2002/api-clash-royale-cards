package com.project.cr.config;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidException(MethodArgumentNotValidException exception){
        Map<String, String> erros = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            erros.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return erros;
    }
}
