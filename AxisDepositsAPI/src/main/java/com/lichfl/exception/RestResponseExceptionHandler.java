package com.lichfl.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler
{

	ErrorMessage errorMessage;
	//private final Logger logger = LoggerFactory.getLogger(RestResponseExceptionHandler.class);

	@ExceptionHandler(TransactionException.class)
	public final ResponseEntity<ErrorMessage> handleNoDataFoundException(TransactionException exp) {
		
		logger.info("Exception message :"+exp);

		
		errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, 
				exp.getMessage(), 
				ZonedDateTime.now(ZoneId.of("Z"))
			);

	  	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	} 
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleGlobalExp(Exception ex , WebRequest webRequest)
	{
		errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST, 
				ex.getMessage(), 
				ZonedDateTime.now(ZoneId.of("Z"))
			);
		
	  	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);

	}
   



	
}
