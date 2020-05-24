package com.mono40.types.exception;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class NonUniqueUserNameException extends NeoAPIException {

    {
        super.setExceptionLevel(ExceptionLevel.WARN);
    }

    public NonUniqueUserNameException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public NonUniqueUserNameException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public NonUniqueUserNameException(Object requestParams) {
        super(requestParams);
    }
}
