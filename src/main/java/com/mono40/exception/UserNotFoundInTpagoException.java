package com.mono40.exception;

/**
 * Created by yarielinfante on 2/22/17.
 */
public class UserNotFoundInTpagoException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public UserNotFoundInTpagoException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public UserNotFoundInTpagoException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public UserNotFoundInTpagoException(Object requestParams) {
        super(requestParams);
    }
}