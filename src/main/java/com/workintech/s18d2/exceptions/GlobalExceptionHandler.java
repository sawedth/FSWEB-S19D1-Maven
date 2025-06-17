package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    private ResponseEntity<PlantErrorResponse> handleException(PlantException plantException){
        log.error("A plant error occurred: " + plantException);
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(plantException.getMessage());
        return new ResponseEntity<>(plantErrorResponse, plantException.getHttpStatus());
    }

    @ExceptionHandler
    private ResponseEntity<PlantErrorResponse> handleException(Exception exception){
        log.error("A plant error occurred: " + exception);
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(exception.getMessage());
        return new ResponseEntity<>(plantErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
