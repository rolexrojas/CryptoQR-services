package com.mono40.types.exception;

/**
 * Created by yarielinfante on 1/25/17.
 */
public class DeviceAlreadyAssociatedException extends NeoAPIException{
    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public DeviceAlreadyAssociatedException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public DeviceAlreadyAssociatedException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }

    public DeviceAlreadyAssociatedException(Object requestParams) {
        super(requestParams);
    }
}
