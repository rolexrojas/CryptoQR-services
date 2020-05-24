package com.mono40.types.exception;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class InvalidMsisdnException extends NeoAPIException {
    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public InvalidMsisdnException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public InvalidMsisdnException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public InvalidMsisdnException(Object requestParams) {
        super(requestParams);
    }
}
