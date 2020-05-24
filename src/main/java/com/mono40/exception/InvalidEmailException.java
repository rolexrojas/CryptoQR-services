package com.mono40.exception;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class InvalidEmailException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public InvalidEmailException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public InvalidEmailException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public InvalidEmailException(Object requestParams) {
        super(requestParams);
    }
}
