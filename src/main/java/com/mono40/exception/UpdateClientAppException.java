package com.mono40.exception;

public class UpdateClientAppException extends NeoAPIException {

    public UpdateClientAppException() {
        super();
    }

    public UpdateClientAppException(Object requestParams) {
        super(requestParams);
    }

    {
        setExceptionLevel(ExceptionLevel.WARN);
    }
}
