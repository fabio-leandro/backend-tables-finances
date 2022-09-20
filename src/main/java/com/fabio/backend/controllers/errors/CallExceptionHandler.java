package com.fabio.backend.controllers.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CallExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MsgError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        MsgError msgError = new MsgError();
        msgError.setStatus(HttpStatus.BAD_REQUEST.value());
        msgError.setMessage(e.getFieldError().getDefaultMessage());
        msgError.setError("Field validation Error. Field: "+ e.getFieldError().getField());
        msgError.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msgError);
    }
}
