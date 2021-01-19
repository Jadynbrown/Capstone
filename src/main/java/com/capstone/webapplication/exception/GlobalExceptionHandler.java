package com.capstone.webapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import javax.persistence.EntityNotFoundException;
import com.capstone.webapplication.exception.*; 

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	//handle specific exceptions
	
	
	//handle global exceptions
	@ExceptionHandler(EntityNotFoundException.class) 
	protected ResponseEntity handleEntityNotFoundException(EntityNotFoundException exception) {
	       ErrorDetails error = new ErrorDetails(HttpStatus.NOT_FOUND);
	       error.setMessage(exception.getMessage());
	       return new ResponseEntity(error, error.getStatus());
	       //return buildResponseEntity(error);
	   }
}
/*

It's a private method at the end of the RestExceptionHandler class you link to:

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
*/
