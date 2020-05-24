package com.mono40.types.exception;

/**
 * Created by yarielinfante on 1/19/17.
 */
public class AnotherDeviceLinkedException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public AnotherDeviceLinkedException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public AnotherDeviceLinkedException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public AnotherDeviceLinkedException(Object requestParams) {
        super(requestParams);
    }
}
