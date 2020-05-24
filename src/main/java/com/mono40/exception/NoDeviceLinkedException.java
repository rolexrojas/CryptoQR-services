package com.mono40.exception;

/**
 * Created by yarielinfante on 1/19/17.
 */
public class NoDeviceLinkedException extends NeoAPIException{

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public NoDeviceLinkedException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public NoDeviceLinkedException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public NoDeviceLinkedException() {
    }

    public NoDeviceLinkedException(Object requestParams) {
        super(requestParams);
    }
}
