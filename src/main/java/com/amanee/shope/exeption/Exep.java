package com.amanee.shope.exeption;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.util.stream.Collectors.toList;

@Data
public class Exep{

    @ExceptionHandler(BindException.class)
    private ResponseEntity<?> handleBind(BindException ex){
        var errors = ex.getFieldErrors()
                .stream()
                .map(fe->String.format("%s -> %s",
                        fe.getField(),fe.getDefaultMessage()))
                .collect(toList());
        return ResponseEntity.unprocessableEntity()
                .body(errors);
    }
}
