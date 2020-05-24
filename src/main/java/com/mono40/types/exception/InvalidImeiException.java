package com.mono40.types.exception;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class InvalidImeiException extends NeoAPIException {
    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public InvalidImeiException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public InvalidImeiException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public InvalidImeiException(Object requestParams) {
        super(requestParams);
    }
}
