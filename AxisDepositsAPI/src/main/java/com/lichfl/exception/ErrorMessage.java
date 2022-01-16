package com.lichfl.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
	
	private HttpStatus status;
	private String message;
	private ZonedDateTime timestamp;

	
	

}
