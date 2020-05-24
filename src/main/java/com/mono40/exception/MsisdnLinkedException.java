package com.mono40.exception;

/**
 * Created by yarielinfante on 1/17/17.
 */
public class MsisdnLinkedException extends NeoAPIException {

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

    public MsisdnLinkedException(String message, Throwable cause, Object requestParams) {
        super(message, cause, requestParams);
    }

    public MsisdnLinkedException(Throwable cause, Object requestParams) {
        super(cause, requestParams);
    }


    public MsisdnLinkedException(Object requestParams) {
        super(requestParams);
    }
}
