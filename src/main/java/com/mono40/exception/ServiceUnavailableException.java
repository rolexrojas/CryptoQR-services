package com.mono40.exception;

/**
 * @author jedeleon
 */
public class ServiceUnavailableException extends NeoAPIException {

    public ServiceUnavailableException() {
        super();
    }

    public ServiceUnavailableException(Object requestParams) {
        super(requestParams);
    }
    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public ServiceUnavailableException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public ServiceUnavailableException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

}
