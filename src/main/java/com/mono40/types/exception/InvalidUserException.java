package com.mono40.types.exception;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class InvalidUserException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public InvalidUserException() {
    }

    public InvalidUserException(String message) {
        super(message);
    }

    public InvalidUserException(Exception e) {
        super(e);
    }

    public InvalidUserException(Object requestParams) {
        super(requestParams);
    }
}
