package com.mono40.exception;

/**
 * Created by jedeleon on 9/7/18.
 */
public class EmailConfirmCodeException extends NeoAPIException{
    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public EmailConfirmCodeException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public EmailConfirmCodeException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public EmailConfirmCodeException(Object requestParams) {
        super(requestParams);
    }
}
