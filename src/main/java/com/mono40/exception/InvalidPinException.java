package com.mono40.exception;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class InvalidPinException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public InvalidPinException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public InvalidPinException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public InvalidPinException(Object requestParams) {
        super(requestParams);
    }
}
