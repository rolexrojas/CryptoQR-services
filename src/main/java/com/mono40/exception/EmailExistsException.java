package com.mono40.exception;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class EmailExistsException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public EmailExistsException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public EmailExistsException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public EmailExistsException(Object requestParams) {
        super(requestParams);
    }
}
