package com.kingJava.demo.adviser;

import com.kingJava.demo.exception.NotFoundException;
import com.kingJava.demo.util.StanderdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.http.HttpResponse;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StanderdResponse> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StanderdResponse>(new StanderdResponse(404,"error comming",e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
