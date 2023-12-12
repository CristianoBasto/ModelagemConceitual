package com.nelioalves.cursomc.modelagemconceitual.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nelioalves.cursomc.modelagemconceitual.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHander {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StanderError> objectNotFound( ObjectNotFoundException e, HttpServletRequest request){
	
		StanderError err = new StanderError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}
