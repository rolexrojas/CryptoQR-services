package com.mono40.exception;

/**
 * Created by yinfante on 10/20/17.
 */
public class UserNotActivetPagoException extends NeoAPIException {

    public UserNotActivetPagoException() {
        super();
    }

    public UserNotActivetPagoException(Object requestParams) {
        super(requestParams);
    }

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }

}
