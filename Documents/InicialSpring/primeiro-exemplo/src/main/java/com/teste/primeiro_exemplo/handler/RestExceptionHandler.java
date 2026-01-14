package com.teste.primeiro_exemplo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.teste.primeiro_exemplo.model.error.ErrorMessage;
import com.teste.primeiro_exemplo.model.exception.ResourcesNotFoundException;



@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<?> handleResourcesNotFoundException(ResourcesNotFoundException ex) {
        ErrorMessage errorMessage = new ErrorMessage(
            "Not Found",
            HttpStatus.NOT_FOUND.value(),
            ex.getMessage()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
    
}
