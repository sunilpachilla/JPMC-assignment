package com.sunil.library.library.controller;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sunil.library.library.Exceptions.ResourceNotFoundException;
import com.sunil.library.library.uiModel.ErrorMessage;

@ControllerAdvice
public class GlobalErrorHandler {

	Logger log =  LoggerFactory.getLogger(GlobalErrorHandler.class);
	
	@ExceptionHandler(value=ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> resourceNotFoundException(Throwable th){
		
		ErrorMessage err =  new ErrorMessage();
		err.setErrMessage(th.getMessage());
		err.setErrorDetails(th.getCause());
		err.setErrCode(th.toString());
		err.setDate(new Date());
		
		return new ResponseEntity<ErrorMessage>(err,HttpStatus.BAD_REQUEST);
	}
	
}
