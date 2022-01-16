package com.lichfl.exception;

import org.springframework.stereotype.Component;



@Component

public class TransactionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TransactionException() {
		super();
	}

 
    public TransactionException(String message) {
        super(message);
    }

    public TransactionException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransactionException(Throwable cause) {
        super(cause);
    }

    protected TransactionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
